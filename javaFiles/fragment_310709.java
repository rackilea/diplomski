@Component("userDetailsService")
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    private static String username;
    private static String password;
    private final Logger log = LoggerFactory.getLogger(CustomUserDetailsService.class);

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {



        return new User(CustomUserDetailsService.username,CustomUserDetailsService.password,null);
    }

}


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


    @Inject
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;

    @Inject
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

    }

}