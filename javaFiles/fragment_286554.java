public class ClusterInternalAuthenticationProvider implements AuthenticationProvider {

    public static final String USER = "...";
    public static final String PASSWORD = "...";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken)authentication;

        Object principal = token.getPrincipal();
        Object credentials = token.getCredentials();

        if (principal.equals(USER) && credentials.equals(PASSWORD)) {
            return new UsernamePasswordAuthenticationToken(
                principal,
                credentials,
                Collections.singletonList(new SimpleGrantedAuthority("RELEVANT_AUTHORITY"))
            );
        }

        throw new BadCredentialsException("Sorry mate, wrong credentials...");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
    }
}