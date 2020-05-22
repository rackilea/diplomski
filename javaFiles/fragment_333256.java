public class CookieFilter implements Filter {
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
          for (Cookie ck : cookies) {
            if ("nameOfMyCookie".equals(ck.getName())) {
                // read the cookie etc, etc
                // ....
                // set an object in the current request
                request.setAttribute("myCoolObject", myObject)
            }
        }
        chain.doFilter(request, res);
    }
    public void init(FilterConfig config) throws ServletException {
        // some initialization code called when the filter is loaded
    }
    public void destroy() {
        // executed when the filter is unloaded
    }
}