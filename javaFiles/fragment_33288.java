public class ADCustomUserDetailsContextMapper extends LdapUserDetailsMapper {

    @Autowired
    private UserDetailsService userDetailsService; // ... the service used for DB authentication

    @Override
    public UserDetails mapUserFromContext(DirContextOperations ctx,
            String username, Collection<? extends GrantedAuthority> authorities) {
        return userDetailsService.loadUserByUsername(username);
    }
}