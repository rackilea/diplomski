http
        .authorizeRequests()
        .antMatchers("/private").hasRole("ADMIN")
        .antMatchers("/public").permitAll()
        .antMatchers("/", "/login", "/logout", "/error").permitAll()
        .antMatchers("/**").denyAll()
        .and().formLogin().loginPage("/login");