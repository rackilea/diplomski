OAuth2Authentication authentication = tokenStore.readAuthenticationForRefreshToken(refreshToken);
    if (this.authenticationManager != null && !authentication.isClientOnly()) {
        // The client has already been authenticated, but the user authentication might be old now, so give it a
        // chance to re-authenticate.
        Authentication user = new PreAuthenticatedAuthenticationToken(authentication.getUserAuthentication(), "", authentication.getAuthorities());
        user = authenticationManager.authenticate(user);
        Object details = authentication.getDetails();
        authentication = new OAuth2Authentication(authentication.getOAuth2Request(), user);
        authentication.setDetails(details);
    }