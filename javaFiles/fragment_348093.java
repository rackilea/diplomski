@Bean
public LocalContainerEntityManagerFactoryBean secondEntityManagerFactory() {
    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    vendorAdapter.setGenerateDdl(true);

    LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
    factory.setJpaVendorAdapter(vendorAdapter);
    factory.setPackagesToScan("...entity-package...");
    factory.setDataSource(secondDataSource());
    Map<String, String> props = new HashMap<>();
    props.putAll(secondJpaProperties().getProperties());
    props.putAll(secondJpaProperties().getHibernateProperties(secondDataSource()));
    factory.setJpaPropertyMap(props);
    factory.setPersistenceUnitName("ds2");
    return factory;
}

@Bean
@ConfigurationProperties(prefix = "jpa.datsource2")
public JpaProperties secondJpaProperties() {
    return new JpaProperties();
}