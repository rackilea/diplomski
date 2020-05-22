package com.myapp.security;

public class RedirectLoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, 
            HttpServletResponse httpServletResponse, 
            Authentication authentication) throws IOException, ServletException {

        RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
        redirectStrategy.sendRedirect(httpServletRequest, httpServletResponse, 
            "www.website.com/"+authentication.getName());
    }
}