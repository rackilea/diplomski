@Bean
public DaoAuthenticationProvider authProvider() {
 // LimitLoginAuthenticationProvider is my own class which extends DaoAuthenticationProvider 
    final DaoAuthenticationProvider authProvider = new LimitLoginAuthenticationProvider(); 
    authProvider.setUserDetailsService(userDetailsService);
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
}