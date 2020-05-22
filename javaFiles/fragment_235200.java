public class DomainRedirectFilter extends OncePerRequestFilter {

    private String destinationDomain;
    private String sourceServletPath;

    @Override
    protected void doFilterInternal(HttpServletRequest request, 
             HttpServletResponse response, FilterChain filterChain)
             throws ServletException, IOException {
        String path = request.getServletPath();
        path = StringUtils.replace(path, getSourceServletPath(), "");
        if (request.getQueryString() != null) {
            path += '?' + request.getQueryString();
        }

        response.setHeader( "Location", getDestinationDomain() + path );
        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
        response.setHeader( "Connection", "close" );
    }