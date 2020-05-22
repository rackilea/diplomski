@Override
protected void configure(HttpSecurity http) throws Exception {
    http.formLogin().failureHandler(new AuthenticationFailureHandler() {
        private final Log logger = LogFactory.getLog();

        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception)
                throws IOException, ServletException {
            logger.debug("Returning UNAUTHORIZED HttpStatus: " + exception.getMessage());
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Authentication Failed: " + exception.getMessage());
        }
    });
}