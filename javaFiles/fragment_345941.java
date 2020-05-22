private void handleException(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
            RuntimeException exception) throws IOException, ServletException {
        if (exception instanceof AuthenticationException) {
            if (logger.isDebugEnabled()) {
                logger.debug("Authentication exception occurred; redirecting to authentication entry point", exception);
            }

            sendStartAuthentication(request, response, chain, (AuthenticationException) exception);
        }

        ....
    }