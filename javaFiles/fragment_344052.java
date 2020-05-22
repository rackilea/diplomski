@Bean
public JCacheManagerCustomizer cacheManagerCustomizer() {
    return cm -> {
        cm.createCache("teamConfigs", new MutableConfiguration<>()
            .setExpiryPolicyFactory(CreatedExpiryPolicy     
                .factoryOf(new Duration(MINUTES, 15)));
    };
}