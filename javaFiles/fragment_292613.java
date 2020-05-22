@WebFilter(urlPatterns = "/*")
public class PathingFilter implements Filter { 
    Pattern[] restPatterns = new Pattern[] {
        Pattern.compile("/v0/user:.*")
    };

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {

            String path = ((HttpServletRequest) request).getPathInfo();

            for (Pattern pattern : restPatterns) {
                if (pattern.matcher(path).matches()) {
                    String[] segments = path.split(":");
                    String newPath = segments[0] + "/" + segments[1];
                    newPath = ((HttpServletRequest) request).getServletPath() + "/" + newPath;
                    request.getRequestDispatcher(newPath).forward(request, response);
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }
}