@Bean
public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
    return new JpaTransactionManager(emf);
}

@Bean
LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource pDataSource) {
     HibernateJpaVendorAdapter tJpaVendorAdapter = new HibernateJpaVendorAdapter();
     ...