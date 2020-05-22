@Override
 protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
            // we don't need CSRF because our token is invulnerable
            .csrf().disable()


.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()

            // don't create session

.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
.and()          

            .authorizeRequests()

            // allow anonymous resource requests
            .antMatchers(
                    HttpMethod.GET,
                    "/",
                    "/v2/api-docs",           // swagger
                    "/webjars/**",            // swagger-ui webjars
                    "/swagger-resources/**",  // swagger-ui resources
                    "/configuration/**",      // swagger configuration
                    "/*.html",
                    "/favicon.ico",
                    "/**/*.html",
                    "/**/*.css",
                    "/**/*.js"
            ).permitAll()
            .antMatchers("/auth/**").permitAll()
            .anyRequest().authenticated();

    // Custom JWT based security filter
    httpSecurity
            .addFilterBefore(authenticationTokenFilter, 
UsernamePasswordAuthenticationFilter.class);

    // disable page caching
    httpSecurity.headers().cacheControl();
}