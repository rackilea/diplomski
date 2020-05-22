@Bean
public ResourceServerConfigurer resourceServerConfigurer(final ScopesProperties oauthProperties) {
    return new ResourceServerConfigurerAdapter() {
        @Override
        public void configure(final HttpSecurity http) throws Exception {
            http.sessionManagement().sessionCreationPolicy(NEVER).and()
                .authorizeRequests()
                .mvcMatchers(GET, "/foo")
                .access(oauthProperties.getFooRead())
                .mvcMatchers(GET, "/bar")
                .access(oauthProperties.getBarRead())
                .mvcMatchers(PUT, "/bar")
                .access(oauthProperties.getBarWrite())
                // everything else
                .anyRequest().denyAll();
    }