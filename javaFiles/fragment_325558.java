import au.com.dius.pact.consumer.Pact;
import au.com.dius.pact.consumer.PactProviderRuleMk2;
import au.com.dius.pact.consumer.PactVerification;
import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.model.RequestResponsePact;
import au.com.dius.pact.model.generators.Category;
import au.com.dius.pact.model.generators.RandomIntGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PactIntGeneratorTest {

    @Rule
    public PactProviderRuleMk2 mockProvider = new PactProviderRuleMk2("providerA", "localhost", 8080, this);

    @Pact(consumer = "consumerA", provider = "providerA")
    public RequestResponsePact requestA(PactDslWithProvider builder) throws Exception {
        final DslPart body = new PactDslJsonBody()
                .numberType("id")
                .stringType("content", "Hello johny");

        body.getGenerators()
                .addGenerator(Category.BODY, ".id", new RandomIntGenerator(0, 100));

        return builder
                .uponReceiving("(GET) /foo")
                    .path("/foo")
                    .method("GET")
                .willRespondWith()
                    .status(200)
                    .body(body)
                .toPact();
    }

    @Test
    @PactVerification(fragment = "requestA")
    public void testRequestA() throws IOException, InterruptedException {
        //given:
        final ObjectMapper objectMapper = new ObjectMapper();

        //when:
        final InputStream json = new URL("http://localhost:8080/foo").openConnection().getInputStream();
        final Map response = objectMapper.readValue(json, HashMap.class);

        //then:
        assertThat(((Integer) response.get("id")) > 0, is(true));
        //and:
        assertThat(response.get("content"), is(equalTo("Hello johny")));
    }
}