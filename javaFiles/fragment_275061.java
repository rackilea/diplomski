public class CustomUserDetailsService implements UserDetailsService {
    // ...

    @Override
    public UserDetails loadUserByUsername(String ssoId) throws UsernameNotFoundException {
        // the implementation
    }
}