@Bean
public RepositoryRestConfigurerAdapter repositoryRestConfigurerAdapter() {
    return new RepositoryRestConfigurerAdapter() {
        /**
         * Exposing ID for some entities
         */
        @Override
        public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
            config.exposeIdsFor(MyEntity.class);            
            super.configureRepositoryRestConfiguration(config);
        }

    };
}