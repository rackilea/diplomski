@WebFilter(urlPatterns = "*")
public class ForwardingFilter implements Filter {

    @Override
    public void destroy() {
        return;
    }

    @Override
    public void doFilter(final ServletRequest request,
            final ServletResponse response, final FilterChain chain)
            throws IOException, ServletException {
        // Add an error response to be processed by the JAX-RS container.
        // This would obviously be based on some condition.
        request.setAttribute("errorResponse",
                Response.status(500).entity("Didn't work out!").build());
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        return;
    }
}

@Provider
@ServerInterceptor
@HeaderDecoratorPrecedence
@RequestScoped
public class ForwardingHandlerProvider implements PreProcessInterceptor {

    @Override
    public ServerResponse preProcess(final HttpRequest request,
            final ResourceMethod method) throws Failure,
            WebApplicationException {
        final Response errorResponse = (Response) request
                .getAttribute("errorResponse");
        if (errorResponse != null)
            throw new WebApplicationException(errorResponse);
        return null;
    }
}