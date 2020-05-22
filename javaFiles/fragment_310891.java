public class CustomAuthenticationFilter extends TokenEndpointAuthenticationFilter {

    public CustomAuthenticationFilter(AuthenticationManager authenticationManager, OAuth2RequestFactory oAuth2RequestFactory) {
        super(authenticationManager, oAuth2RequestFactory);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // do your thing, then call super-implementation to continue normal authentication flow
        super.doFilter(request, response, chain);
    }
}