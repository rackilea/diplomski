public class AppUDS implements UserDetailsService {
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException, DataAccessException {
        //create your concrete UserDetails
        //add your custom role (i.e. GrantedAuthority) to that object (that will be added to all users)
        //return it
    }
}