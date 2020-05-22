public class BrandAwareUserPasswordAuthenticationkFilter extends UsernamePasswordAuthenticationFilter {   

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        Authencation auth = super.attemptAuthentication(request, response);

        if(!userBelongsToBrand()) {    // you're on your own here
            throw new BadCredentialsException("your message here"); // you can elect to throw a different exception
        }

        return auth;
    }
}