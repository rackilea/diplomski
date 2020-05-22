@Component
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private MyUserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final MyUserDetails user = userDAO.getUserByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("No user found for username '" + username +"'.");
        }
        return user;
    }
}