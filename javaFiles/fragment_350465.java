public class UsernamePasswordAuthenticationFilter extends
        AbstractAuthenticationProcessingFilter {


    public Authentication attemptAuthentication(HttpServletRequest request,
                HttpServletResponse response) throws AuthenticationException {
            if (postOnly && !request.getMethod().equals("POST")) {
                throw new AuthenticationServiceException(
                        "Authentication method not supported: " + request.getMethod());
            }

            String username = obtainUsername(request);
            String password = obtainPassword(request);
            ...
    }

    /**
         * Enables subclasses to override the composition of the password, such as by
         * including additional values and a separator.
         * <p>
         * This might be used for example if a postcode/zipcode was required in addition to
         * the password. A delimiter such as a pipe (|) should be used to separate the
         * password and extended value(s). The <code>AuthenticationDao</code> will need to
         * generate the expected password in a corresponding manner.
         * </p>
         *
         * @param request so that request attributes can be retrieved
         *
         * @return the password that will be presented in the <code>Authentication</code>
         * request token to the <code>AuthenticationManager</code>
         */
        protected String obtainPassword(HttpServletRequest request) {
            return request.getParameter(passwordParameter);
        }

        /**
         * Enables subclasses to override the composition of the username, such as by
         * including additional values and a separator.
         *
         * @param request so that request attributes can be retrieved
         *
         * @return the username that will be presented in the <code>Authentication</code>
         * request token to the <code>AuthenticationManager</code>
         */
        protected String obtainUsername(HttpServletRequest request) {
            return request.getParameter(usernameParameter);
        }