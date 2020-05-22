@Override
protected void configure(HttpSecurity http) throws Exception {
    http
        .oauth2Login()
            .failureHandler(new CustomAuthenticationFailureHandler());
}