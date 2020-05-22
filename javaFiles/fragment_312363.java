@Resource(name = "authService")
private UserDetailsService userDetailsService;

@Override
protected void configure(HttpSecurity http) throws Exception {
                http.csrf().disable().
                        exceptionHandling().authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login")).accessDeniedPage("/accessDenied")
                        .and().authorizeRequests()
                        .antMatchers("/VAADIN/**", "/PUSH/**", "/UIDL/**", "/login", "/login/**", "/error/**", "/accessDenied/**", "/vaadinServlet/**").permitAll()
                        .antMatchers("/authorized", "/**").fullyAuthenticated();
            }

            @Bean
            public DaoAuthenticationProvider createDaoAuthenticationProvider() {
                DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

                provider.setUserDetailsService(userDetailsService);
                provider.setPasswordEncoder(passwordEncoder());
                return provider;
            }

            @Bean
            public BCryptPasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
            }