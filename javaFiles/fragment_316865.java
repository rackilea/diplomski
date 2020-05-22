public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    int n = appMetier.getAppsCount();
    InMemoryClientDetailsServiceBuilder clientBuilder = clients.inMemory();

    for (App app:appMetier.findAll(0, n).getApps()) {
        clientBuilder.withClient(app.getClientPublicId()).authorizedGrantTypes("password", "refresh_token")
            .scopes("read", "write").resourceIds(RESOURCE_ID).secret(app.getClientSecretId());
    }
}