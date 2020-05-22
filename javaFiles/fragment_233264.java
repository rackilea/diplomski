public class UserDetailsServiceImpl extends UserDetailsService {

    @Override
    @Transactional(propagation = SUPPORTS, readOnly = true)
    public CurrentUser loadUserByUsername(String username) 
            throws AuthenticationException ,DataAccessException {
        ensureNotEmpty(username);
        User user = userRepository.findUserWithAuthorities(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid credentials!");
        }
        return new CurrentUser(user);
    }
}