public <T extends UserDetailsService>
        DaoAuthenticationConfigurer<AuthenticationManagerBuilder,T>
        userDetailsService(T userDetailsService) throws Exception {

    this.defaultUserDetailsService = userDetailsService;
    return apply(
        new DaoAuthenticationConfigurer<AuthenticationManagerBuilder,T>
        (userDetailsService));
}