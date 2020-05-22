.antMatchers(HttpMethod.GET, "/api/polls/**", "/api/users/**").permitAll()
  .antMatchers("/api/brands/**").permitAll()      
  .antMatchers("/api/familys/**").permitAll()
  .antMatchers("/api/models/**").permitAll()
.anyRequest()
        .authenticated();;