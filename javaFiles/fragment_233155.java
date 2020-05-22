private static final String CSRF_HEADER_NAME = "XSRF-TOKEN";

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
            ...
            .and()
                .csrf()
                    .ignoringAntMatchers(CSRF_IGNORE)
                    .csrfTokenRepository(csrfTokenRepository())
            .and()
               .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class);
    }

    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName(CSRF_HEADER_NAME);
        return repository;
    }