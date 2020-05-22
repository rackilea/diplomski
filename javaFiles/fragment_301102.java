public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        //
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;          
        if(request.getParameter("language")==null) {
              String userLocale = request.getHeader("Accept-Language");
              Locale locale = request.getLocale();
              String requestURI = request.getRequestURI();

              // put your logic for userLocale and redirect accordingly          

             }
    }

    @Override
    public void destroy() {
        //
    }
}