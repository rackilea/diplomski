http.addFilterBefore(new MyAuthenticationFilter(authenticationManager()), BasicAuthenticationFilter.class)
            .authorizeRequests()
                .antMatchers("/login").hasAnyRole()
                .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .httpBasic().disable();