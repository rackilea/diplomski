public class CustomUserDetailsContextMapper implements UserDetailsContextMapper {


    private LdapUser ldapUser = null;
    private String commonName;

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx, String username, Collection<? extends GrantedAuthority> authorities) {
        Attributes attributes = ctx.getAttributes();
        UserDetails ldapUserDetails = (UserDetails) super.mapUserFromContext(ctx,username,authorities);
        try {
            commonName = attributes.get("cn").get().toString();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        ldapUser = new LdapUser(ldapUserDetails);
        ldapUser.setCommonName(commonName);
        return ldapUser;
    }

    @Override
    public void mapUserToContext(UserDetails user, DirContextAdapter ctx) {

    }
}