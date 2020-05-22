http.addFilterBefore(new MyAuthenticationFilter(authenticationManager()), BasicAuthenticationFilter.class)
            .authorizeRequests()
                .anyRequest().authenticated()
            .and()
            .csrf().disable()
            .httpBasic().disable();