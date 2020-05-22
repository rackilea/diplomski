@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        String profile = determineConfigProfile();
        System.setProperty("spring.cloud.config.profile", profile);
        return application.sources(Application.class);
    }