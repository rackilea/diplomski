public class OverrideActiveDirectoryLdapAuthenticationProvider extends TestActiveDirectoryLdapAuthenticationProvider {

//my assignments

public OverrideActiveDirectoryLdapAuthenticationProvider(String domain,
        String url) {
    super(domain, url);
}

@Override
protected Collection<? extends GrantedAuthority> loadUserAuthorities(DirContextOperations userData, String username, String password) {
//original code with my own additions
//in my case, I injected code into the for(group : groups) loop
}