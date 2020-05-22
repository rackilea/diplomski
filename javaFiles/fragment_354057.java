@Configuration
@EnableTransactionManagement
public class ComplexComponentConfig {

    /** NOT A @Bean, this object will be wrapped with a transactional proxy */
    public ComplexComponent complexComponentImpl() {
        return new ComplexComponentImpl(repository());
    }

    @Bean
    public ComplexComponent complexComponent() {
        TransactionProxyFactoryBean proxy = new TransactionProxyFactoryBean();

        // Inject transaction manager here
        proxy.setTransactionManager(txManager());

        // Define wich object instance is to be proxied (your bean)
        proxy.setTarget(complexComponentImpl());

        // Programmatically setup transaction attributes
        Properties transactionAttributes = new Properties();
        transactionAttributes.put("*", "PROPAGATION_REQUIRED");
        proxy.setTransactionAttributes(transactionAttributes);

        // Finish FactoryBean setup
        proxy.afterPropertiesSet();
        return (ComplexComponent) proxy.getObject;
    }

// ...
}