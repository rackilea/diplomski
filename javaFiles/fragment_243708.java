@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        InMemoryClientDetailsService clientDetails = new InMemoryClientDetailsService();
        BaseClientDetails client = new BaseClientDetails(
            "testclient",
            null,
            "testscope,USER,ADMIN",
            "password",
            null
        );
        client.setClientSecret(passwordEncoder.encode("secret"));
        clientDetails.setClientDetailsStore(
            Collections.singletonMap(
                client.getClientId(),
                client
            )
        );
        clients.withClientDetails(clientDetails);
    }