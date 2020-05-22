public class ThirdPartyAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication auth) thows AuthenticationException {
        // call third party site with auth.getPrincipal() and auth.getCredentials() (those are username and password)
        // Throw AuthenticationException if response is not 200
        return new UsernamePasswordAuthenticationToken(...);
    }

    @Override
    public boolen supports(Class<?> authCls) {
        return UsernamePasswordAuthenticationToken.class.equals(authCls);
    }
}