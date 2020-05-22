package org.springframework.test.web.servlet.request;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpMethod;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * Patched version of {@link MockHttpServletRequestBuilder}.
 *
 * @author Sam Brannen
 * @since 4.2
 */
public class PatchedMockHttpServletRequestBuilder extends MockHttpServletRequestBuilder {

    public static MockHttpServletRequestBuilder get(String urlTemplate, Object... urlVariables) {
        return new PatchedMockHttpServletRequestBuilder(HttpMethod.GET, urlTemplate, urlVariables);
    }

    public PatchedMockHttpServletRequestBuilder(HttpMethod httpMethod, String urlTemplate, Object... urlVariables) {
        super(httpMethod, urlTemplate, urlVariables);
    }

    /**
     * Create a {@link MockHttpServletRequest}.
     * <p>If an instance of {@code MockHttpServletRequest} is available via
     * the {@link RequestAttributes} bound to the current thread in
     * {@link RequestContextHolder}, this method simply returns that instance.
     * <p>Otherwise, this method creates a new {@code MockHttpServletRequest}
     * based on the supplied {@link ServletContext}.
     * <p>Can be overridden in subclasses.
     * @see RequestContextHolder#getRequestAttributes()
     * @see ServletRequestAttributes
     */
    @Override
    protected MockHttpServletRequest createServletRequest(ServletContext servletContext) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes instanceof ServletRequestAttributes) {
            HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
            if (request instanceof MockHttpServletRequest) {
                return (MockHttpServletRequest) request;
            }
        }

        return new MockHttpServletRequest(servletContext);
    }

}