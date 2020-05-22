public class DelegatingLdapAuthenticationProvider implements AuthenticationProvider {
    // Inject these via the app context
    private LdapAuthenticationProvider primary;
    private LdapAuthenticationProvider secondary;

    public Authentication authenticate(Authentication a) {
        if (a.getName().contains("secondDomain")) {
            return secondary.authenticate(a);
        } else {
            return primary.authenticate(a);
        }
    }
}