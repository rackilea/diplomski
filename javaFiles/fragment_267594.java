@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.ldapAuthentication()
      .contextSource()
        .url(...)
        .port(...)
        .managerDn(...)
        .managerPassword(...)
      .and()
        .passwordEncoder(passwordEncoder())
        .userSearchBase(...)        
        .ldapAuthoritiesPopulator(new UserServiceLdapAuthoritiesPopulater(this.userService));      
}