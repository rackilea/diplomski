public class ApplicationSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailSecurityService userDetailSecurityService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests().antMatchers("/static").permitAll().anyRequest()
                .fullyAuthenticated();

        http
                .csrf().disable()
                .formLogin().loginPage("/login").failureUrl("/login?error=1")
                .permitAll().defaultSuccessUrl("/")
                .successHandler(
                        new NoRedirectSavedRequestAwareAuthenticationSuccessHandler())
                .and()
                    .sessionManagement()
                    .sessionAuthenticationErrorUrl("/notauthorized")
                    .invalidSessionUrl("/notauthorized")
                .and()
                    .logout()
                    .deleteCookies("JSESSIONID", "SESSION")
                .permitAll();
    }

    //If you want to add some encoder method to store your passwords
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailSecurityService).passwordEncoder(passwordEncoder());
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new MD5PasswordEncoder();
    }


    private class NoRedirectSavedRequestAwareAuthenticationSuccessHandler extends
            SimpleUrlAuthenticationSuccessHandler {

        final Integer SESSION_TIMEOUT_IN_SECONDS = 30 * 60; /** 30 min */

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request,
                                            HttpServletResponse response, Authentication authentication)
                throws ServletException, IOException {

            request.getSession().setMaxInactiveInterval(SESSION_TIMEOUT_IN_SECONDS);
            response.sendRedirect("/");
        }
    }
}