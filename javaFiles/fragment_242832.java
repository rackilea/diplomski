@Bean
public RepositoryRestConfigurerAdapter repositoryRestConfigurerAdapter() {
    return new RepositoryRestConfigurerAdapter() {
        @Override
        public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
            config.exposeIdsFor(ContentPath.class);
            super.configureRepositoryRestConfiguration(config);
        }
    };
}