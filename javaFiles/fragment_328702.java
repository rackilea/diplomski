@Override
protected void configure(final HttpSecurity http) throws Exception {
    http
        .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
}