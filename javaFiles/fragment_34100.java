import jersey.stackoverflow.jaxrs.ResponseWrapper;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.moxy.json.MoxyJsonConfig;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.glassfish.jersey.test.TestProperties;
import org.junit.Test;

public class TestTestResource extends JerseyTest {

    @Test
    public void testPostReturn() throws Exception {
        final WebTarget target = target("test");
        final ResponseWrapper ro = target.request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(new ResponseWrapper()
                        , MediaType.APPLICATION_JSON_TYPE), ResponseWrapper.class);
        System.out.println(ro);

    }

    @Override
    protected Application configure() {
        enable(TestProperties.LOG_TRAFFIC);
        enable(TestProperties.DUMP_ENTITY);

        return createApp();
    }

    @Override
    protected void configureClient(ClientConfig config) {
        config.register(createMoxyJsonResolver());
    }

    public static ResourceConfig createApp() {
        // package where resource classes are
        return new ResourceConfig().
                packages("jersey.stackoverflow.jaxrs").
                register(createMoxyJsonResolver());
    }

    public static ContextResolver<MoxyJsonConfig> createMoxyJsonResolver() {
        final MoxyJsonConfig moxyJsonConfig = new MoxyJsonConfig();
        Map<String, String> namespacePrefixMapper = new HashMap<String, String>(1);
        namespacePrefixMapper.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        moxyJsonConfig.setNamespacePrefixMapper(namespacePrefixMapper).setNamespaceSeparator(':');
        return moxyJsonConfig.resolver();
    }
}