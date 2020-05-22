static HttpSecurity configureHttpSec(HttpSecurity http, String urlBase) throws Exception {
    http   .csrf().disable()
           .exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint())
    .and() .antMatchers(urlBase+"/**").authorizeRequests().anyRequest().authenticated()
    .and() .httpBasic()
    .and() .logout().logoutUrl(urlBase+"/logout").logoutSuccessHandler((req,resp,auth) -> {})
    ;
    return http;
  }