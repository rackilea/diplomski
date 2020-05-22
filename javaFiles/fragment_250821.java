@Override
public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, 
        HttpServletResponse httpServletResponse, 
        Authentication authentication) throws IOException, ServletException {

    RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, 
    "/welcome/"+authentication.getName());
}