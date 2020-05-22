/**
 * @return {@link SecurityConfig}
 */
@Bean
public SecurityConfig securityConfigBean() {
    SecurityConfig config = new SecurityConfig("kupo-security");
    return config;
}

/**
 * 
 * @param auth {@link AuthenticationManagerBuilder}
 * @throws Exception {@link Exception} 
 */
@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.authenticationProvider(authProviders().getDaoProvider());
}

@Bean
@Override
public AuthenticationManager authenticationManagerBean() throws Exception {
    return new ProviderManager(authProviders());
}