import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.request.ServletRequestAttributes;

@Provider
public class RequestFilter implements ContainerRequestFilter {
    private static final String REQUEST_ATTRIBUTES_ATTRIBUTE =
            RequestFilter.class.getName() + ".REQUEST_ATTRIBUTES";

    @Context private HttpServletRequest httpRequest;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        ServletRequestAttributes attributes = new ServletRequestAttributes(httpRequest);
        httpRequest.setAttribute(REQUEST_ATTRIBUTES_ATTRIBUTE, attributes);
        LocaleContextHolder.setLocale(httpRequest.getLocale());
        RequestContextHolder.setRequestAttributes(attributes);
    }

}