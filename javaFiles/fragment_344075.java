@Override
protected void configure (HttpSecurity http) throws Exception
{
  http
      .exceptionHandling()
          // this entry point handles when you request a protected page and
          // you are not yet authenticated
          .authenticationEntryPoint(digestEntryPoint())
          .and()
      .authorizeUrls()
          .antMatchers("/firstres/*").permitAll()
          .antMatchers("/secondres/*").permitAll()
          .antMatchers("/resources/*").permitAll()
          .antMatchers("/**").hasAnyAuthority("first_role", "second_role").and()
      // the entry point on digest filter is used for failed authentication attempts
      .addFilter(digestAuthenticationFilter(digestEntryPoint()));
}

@Override
@Bean
public UserDetailsService userDetailsServiceBean() {
    return super.userDetailsServiceBean();
}

public DigestAuthenticationFilter digestAuthenticationFilter (
    DigestAuthenticationEntryPoint digestAuthenticationEntryPoint)
{
  DigestAuthenticationFilter digestAuthenticationFilter = new DigestAuthenticationFilter();
  digestAuthenticationFilter.setAuthenticationEntryPoint(digestEntryPoint());
  digestAuthenticationFilter.setUserDetailsService(userDetailsServiceBean());
  return digestAuthenticationFilter;
}