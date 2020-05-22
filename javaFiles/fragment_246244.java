@Configuration
public class CamundaConfiguration {
    ....

    @Bean
    public JpaDialect jpaDialect() {
        return new org.springframework.orm.jpa.vendor.HibernateJpaDialect();
    }

    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setJpaDialect(jpaDialect());
        bean.setJpaVendorAdapter(new org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter());
        ...
        return bean;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager bean = new JpaTransactionManager(entityManagerFactory());
        bean.setJpaDialect(jpaDialect());
        ...
        return bean;
    }

    ...
}