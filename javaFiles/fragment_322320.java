OAuthClientRequest request = OAuthClientRequest
                .tokenLocation(TOKEN_URL)
                .setGrantType(GrantType.AUTHORIZATION_CODE)
                .setClientId(CLIENT_ID)
                .setClientSecret(CLIENT_SECRET)
                .setRedirectURI(REDIRECT_URL)
                .setCode(authorizationCode)
                .buildQueryMessage();
                //.buildBodyMessage();