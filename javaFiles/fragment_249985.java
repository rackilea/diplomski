import org.jboss.resteasy.core.Dispatcher;
import org.jboss.resteasy.mock.MockDispatcherFactory;
import org.jboss.resteasy.mock.MockHttpRequest;
import org.jboss.resteasy.mock.MockHttpResponse;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CookieTest {
    static final String COOKIE_NAME = "parameterCookie";

    Dispatcher dispatcher;

    @Before
    public void setUp() throws Exception {
        dispatcher = MockDispatcherFactory.createDispatcher();
        dispatcher.getRegistry().addSingletonResource(new Resource());
    }

    @Test
    public void name_StateUnderTest_ExpectedBehavior() throws Exception {
        String cookieValue = String.valueOf(System.currentTimeMillis());

        MockHttpResponse response = new MockHttpResponse();
        MockHttpRequest request = MockHttpRequest.get("/")
                                    .cookie(COOKIE_NAME, cookieValue);

        dispatcher.invoke(request, response);

        assertThat(response.getContentAsString(), is(COOKIE_NAME + "=" + cookieValue));
    }

    @Path("/")
    public static class Resource {
        @Context HttpHeaders headers;

        @GET @Path("/")
        public String getCookie(){
            return headers.getCookies().get(COOKIE_NAME).toString();
        }
    }
}