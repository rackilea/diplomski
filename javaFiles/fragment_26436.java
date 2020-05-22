@Configuration
@EnableWebMvcSecurity
public class SecurityConfig {

    @Configuration
    @Order(1)
    public static class FrontEndSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        @Qualifier("frontend")
        private UserDetailsService frontendUserDetailsService;

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                .userDetailsService(frontendUserDetailsService)
                    .passwordEncoder(passwordEncoder);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/frontend/**")
                .authorizeRequests()
                    .anyRequest()
                    .hasRole("USER")
                    .and()
                .formLogin();
        }
    }

    @Configuration
    @Order(2)
    public static class BackendSecurityConfiguration extends WebSecurityConfigurerAdapter {

        @Autowired
        private PasswordEncoder passwordEncoder;

        @Autowired
        @Qualifier("management")
        private UserDetailsService managementUserDetailsService;

        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth
                .userDetailsService(managementUserDetailsService)
                    .passwordEncoder(passwordEncoder);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/manage/**")
                .authorizeRequests()
                    .anyRequest()
                    .hasRole("ADMIN")
                    .and()
                .formLogin();
        }
    }
}