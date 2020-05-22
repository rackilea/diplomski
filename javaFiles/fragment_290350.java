@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
      .antMatchers("/admin/login").permitAll()
      .antMatchers("/admin/**").hasAnyAuthority(rolesForAdmin)
      .antMatchers("/subscriber-register/**").permitAll()
    .and()
      .csrf().disable().httpBasic().disable().cors();
}