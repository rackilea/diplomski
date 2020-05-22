import static javax.ws.rs.core.Response.Status.*;
import static org.junit.rules.ExpectedException.*;

import javax.ws.rs.core.Response.Status;

import org.hamcrest.*;
import org.junit.*;
import org.junit.rules.ExpectedException;

import com.sun.jersey.api.client.*;

public class MyResourceShould {

    @Rule
    public ExpectedException unsuccessfulResponse = none();

    private WebResource resource;

    @Before
    public void setUp() {
        Client client = Client.create();
        client.setFollowRedirects(false);
        resource = client.resource("http://example.com");
    }

    @Test
    public void reportMovedPermanently() {
        unsuccessfulResponse.expect(statusCode(MOVED_PERMANENTLY));

        resource.path("redirecting").get(String.class);
    }

    public static Matcher<UniformInterfaceException> statusCode(Status status) {
        return new UniformInterfaceExceptionResponseStatusMatcher(status);
    }

}

class UniformInterfaceExceptionResponseStatusMatcher extends TypeSafeMatcher<UniformInterfaceException> {

    private final int statusCode;

    public UniformInterfaceExceptionResponseStatusMatcher(Status status) {
        this.statusCode = status.getStatusCode();
    }

    public void describeTo(Description description) {
        description.appendText("response with status ").appendValue(statusCode);
    }

    @Override
    protected boolean matchesSafely(UniformInterfaceException exception) {
        return exception.getResponse().getStatus() == statusCode;
    }

}