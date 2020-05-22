@ServletFilter(urlPatterns={"*.html"}) 
public class MyFilter implements javax.servlet.Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) {
        HttpServletRequest httpReq = (HttpServletRequest) req;
        HttpServletResponse httpRes = (HttpServletResponse) res;
        HttpSession session = httpReq.getSession();

        boolean isLoggedIn = <Your code to check if user is logged in>

        if (isLoggedIn) { 
            // User logged in, forward to html page
            chain.doFilter(request, response);
        } else {
            // User not logged in, redirect to login page
            httpRes.sendRedirect("/login.html");
        }
    }
}