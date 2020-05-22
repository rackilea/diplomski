AuthConfig authConfig = new AuthConfigBuilder().withUsername("anuruddhal").withPassword
                ("xxxxxxx")
                .build();
        Config config = new ConfigBuilder()
                .withDockerUrl(dockerUrl)
                .addToAuthConfigs("index.docker.io", authConfig)
                .build();