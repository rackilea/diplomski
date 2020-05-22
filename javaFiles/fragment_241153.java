public class MyAuthenticationProvider implements AuthenticationProvider, Serializable {

    @Override
    public boolean supports(Class<? extends Object> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

    // ...
}