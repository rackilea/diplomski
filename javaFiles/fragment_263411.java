http
   .authorizeRequests()
   .antMatchers("/lib/bootstrap/**",
                "/css/**",
                "/img/**",
                "/js/**").permitAll();