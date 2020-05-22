import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;

public class MockitoInjectMocksTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private ContainerRequestContext requestContext;

    /**
     * With the @InjectMocks annotation, Mockito will
     * inject the filter with the mock HttpServletRequest
     */
    @InjectMocks
    private Filter filter = new Filter();

    @Before
    public void setUp() {
        // Handle all the mock creation and injection.
        MockitoAnnotations.initMocks(this);

        // Mock the HttpServletRequest#getRemoteAddr()
        // method to return a dummy IP address.
        Mockito.when(request.getRemoteAddr())
                .thenReturn("122.21.32.233");
    }

    /**
     * See the `Filter` class below. The `filter()` method doesn't
     * do much. It just grabs the remote IP address from the
     * `HttpServletRequest` and uses it to set a property on
     * the `ContainerRequestContext`. This test asserts that
     * the arguments passed to the `setProperty()` method
     * method are the correct arguments. We do that with the
     * help of Mockito's `ArgumentCaptor`,
     */
    @Test
    public void testIpPropertySet() throws Exception {
        // Call the `filter()` method that we are testing,
        // passing in the mock `ContainerRequestContext`.
        // We use a mock so that we can later verify methods
        // on it are called
        filter.filter(requestContext);

        // We create argument captors to capture the args of call to
        // `ContainerRequestContext#setProperty(String, String)`
        ArgumentCaptor<String> propNameArg = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<String> propValArg = ArgumentCaptor.forClass(String.class);

        // Verify the `ContainerRequestContext#setProperty()`
        // is called. We use the `ArgumentCaptors` to capture
        // the arguments that are passed when `setProperty()`
        // is called.
        Mockito.verify(requestContext)
               .setProperty(propNameArg.capture(), propValArg.capture());

        // Test that the arguments passed in the call to
        // `ContainerRequestContext#setProperty()` are correct.
        assertThat(propNameArg.getValue()).isEqualTo("RemoteAddress");
        assertThat(propValArg.getValue()).isEqualTo("122.21.32.233");
    }

    public static class Filter implements ContainerRequestFilter {

        @Context
        private HttpServletRequest request;

        @Override
        public void filter(ContainerRequestContext requestContext) throws IOException {
            System.out.println(request.getRemoteAddr());
            requestContext.setProperty("RemoteAddress", request.getRemoteAddr());
        }
    }
}