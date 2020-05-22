public PlatformTransactionManager transactionManager() {

        // JtaTransactionManager.
        JtaTransactionManager transactionManager = new JtaTransactionManager();


        return transactionManager;
    }




@Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean() {

        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
            em.seJtatDataSource(dataSource());
...
...
}