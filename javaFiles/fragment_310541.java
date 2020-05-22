Keycloak keycloak = KeycloakBuilder.builder()
.serverUrl(KEYCLOAK_TOKEN_RESOURCE_URI)
.realm(REALM)
.username(KEYCLOAK_USERNAME)
.password(KEYCLOAK_PASSWORD)
.clientId(KEYCLOAK_CLIENT)
.clientSecret(CLIENT_SECRET)
.build();