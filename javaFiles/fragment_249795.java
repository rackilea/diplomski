protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
            .antMatchers("/rest/**").authenticated()
            .and().httpBasic().authenticationEntryPoint(new AuthenticationEntryPoint() {
                @Override
                public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
                    String requestedBy = request.getHeader("X-Requested-By");
                    log.info("X-Requested-By: " + requestedBy);
                    if(requestedBy == null || requestedBy.isEmpty()) {
                        HttpServletResponse httpResponse = (HttpServletResponse) response;
                        httpResponse.addHeader("WWW-Authenticate", "Basic realm=Cascade Realm");
                        httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
                    } else {
                        HttpServletResponse httpResponse = (HttpServletResponse) response;
                        httpResponse.addHeader("WWW-Authenticate", "Application driven");
                        httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, authException.getMessage());
                    }
                }
            });
}