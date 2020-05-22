@Override
    public boolean doAuthenticate(String userAndDomain, String password) {
        UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(replaceBackSlashWithAtSign(userAndDomain), password);
        try {
            Authentication authentication = adAuthenticationProvider.authenticate(userToken);
            return authentication.isAuthenticated();
        } catch (BadCredentialsException e) {
            log.error("Authentication failed - wrong username\\password", e);
            throw new BadCredentialsException("Authentication failed - wrong username\\password", e);
        } catch (AuthenticationException e) {
            log.error("Authentication failed - AuthenticationException", e);
            throw new AuthenticationException("Authentication failed - AuthenticationException", e) { };
        }
    }