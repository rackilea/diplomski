public class ADCustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private ActiveDirectoryLdapAuthenticationProvider adAuthProvider;
    @Autowired
    private UserDao uDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        String principal = authentication.getPrincipal().toString();
        String username = principal.split("@")[0];
        User utente = uDao.findByUsername(username);
        if (utente == null) {
            throw new ADUnregisteredUserAuthenticationException("user ["
                    + principal + "] is not registered");
        }
        return adAuthProvider.authenticate(authentication);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return adAuthProvider.supports(authentication);
    }

}