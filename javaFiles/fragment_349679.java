http
            .csrf()
            .disable()
            .requestMatcher(new BasicRequestMatcher())
            .authorizeRequests()
            .antMatchers("/", "/login**","/callback/", "/webjars/**", "/error**")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic()
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);