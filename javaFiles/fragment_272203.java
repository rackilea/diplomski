public OAuth2AccessToken refreshAccessToken(String refreshTokenValue, 
                                            TokenRequest tokenRequest) {

    // Omitted
    if (!reuseRefreshToken) {
        tokenStore.removeRefreshToken(refreshToken);
        refreshToken = createRefreshToken(authentication);
    }
    // Omitted
}