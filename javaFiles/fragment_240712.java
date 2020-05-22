@Configuration
@EnableWebSecurity
@PropertySource("classpath:application.properties")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

@Value("${url1}")
private String url1;

@Value("${url1}")
private String url2;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      //..
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

      http.authorizeRequests()
        .antMatchers(url1).access("hasRole('ROLE_ADMIN')")
        .antMatchers(url2).access("hasRole('ROLE_USER') ;

    }
}