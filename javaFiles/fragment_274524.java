httpSecurity
  .antMatcher("/**")
  .authorizeRequests()
  .and()
  .authorizeRequests().antMatchers('/actuator/jolokia', '/graphiql', '/voyager').permitAll()
  .and()
  .authorizeRequests().anyRequest().authenticated();