@Autowired
public void configureGlobalSecurity(AuthenticationManagerBuilder authentication) throws Exception {
    authentication.userDetailsService(userDetailsServiceBean());
    //authentication.authenticationProvider(authenticationProvider());
}

@Override
@Bean
public UserDetailsService userDetailsServiceBean() throws Exception {
    return new CustomUserDetailsService();
}