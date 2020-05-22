import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author asif.hossain
 * @since 3/9/17.
 */
public class UserDao implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        String password = readPasswordFromFileOrDatabase(username);

        if (password == null) throw new UsernameNotFoundException("");

        return User
                .withUsername(username)
                .password(password)
                .authorities("ROLE_USER")
                .build();
    }

    private String readPasswordFromFileOrDatabase(String username) {
        // Edit this code and read password and roles from data base or files 
        if (username.equals("user")) return "password";
        return null;
    }
}