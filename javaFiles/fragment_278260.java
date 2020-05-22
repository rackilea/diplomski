for (ClientDetails client : clientRegistrationService.listClientDetails()) {
    for (final OAuth2AccessToken token : tokenStore.findTokensByClientIdAndUserName(clientId, email)) {
        tokenStore.removeRefreshToken(token.getRefreshToken());
        tokenStore.removeAccessToken(token);
    }
}