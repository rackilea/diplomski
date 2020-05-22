return KeycloakUriBuilder.fromUri(authServerRootUrl)
    .path("realms/realmName/protocol/openid-connect/auth") // Url changed
    .queryParam("response_type", "code") // Autherization Code Flow
    .queryParam("scope", "openid") // Add additional scopes if needed
    .queryParam("kc_idp_hint", "google") // This should match IDP name registered in Keycloak
    .queryParam("nonce", nonce)
    .queryParam("hash", hash)
    .queryParam("client_id", clientId)
    .queryParam("redirect_uri", redirectUri).build(realm, provider).toString();