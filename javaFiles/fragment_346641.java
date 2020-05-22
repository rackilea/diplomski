@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Autowired
CustomUserDetailsMapper userDetailsMapper;

@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

    auth.
                ldapAuthentication().userDnPatterns("cn={0}").userDetailsContextMapper(userDetailsMapper)
                .contextSource(contextSource())
}