OAuthClientRequest request = OAuthClientRequest
                .authorizationLocation(AUTH_URL)
                .setClientId(CLIENT_ID)
                .setRedirectURI(REDIRECT_URL)
                .setResponseType("code")
                .setScope("openid,email,profile,offline_access")
                .buildQueryMessage();