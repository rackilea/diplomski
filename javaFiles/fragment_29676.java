// in filter class
@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
    throws ServletException {

    int userId;

    // do something to get your authentication data (userId)
    // ...
    // wrap the original request with the "AuthenticatedRequest" 
    AuthenticatedRequest authRequest = new AuthenticatedRequest(req, userId);

    // forward the AuthenticatedRequest to the servlet
    chain.doFilter(authRequest, res);

}