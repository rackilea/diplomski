@Service
public class UserDetailSecurityService implements UserDetailsService{

    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /*Here in your case would call your WebService and check if the result is Y/N and return the UserDetails object with all roles, etc
        If the user is not valid you could throw an exception
        */
        return userService.findByUsername(username);
    }
}