public LocalContainerEntityManagerFactoryBean postgresqlEntityManagerFactory(EntityManagerFactoryBuilder builder) {
        return builder
                .dataSource(postgresqlDataSource())
                .properties(hibernateProperties())
                .packages("com.server.entity.postgresql")
                .persistenceUnit("postgresqlPU")
                .build();