@Autowired
public void configureGlobal(AuthenticationManagerBuilder auth,
        AuthenticationProvider provider) throws Exception {

    inMemoryConfigurer()
        .withUser("admin")
            .password("s3cr3t")
            .authorities("ADMIN")
        .and()
        .configure(auth);
    auth.authenticationProvider(provider);
}

private InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder>
        inMemoryConfigurer() {
    return new InMemoryUserDetailsManagerConfigurer<>();
}