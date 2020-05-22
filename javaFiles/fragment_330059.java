@Bean
public BatchConfigurer batchConfigurer() {
    return new DefaultBatchConfigurer() {
            @Override
            public PlatformTransactionManager getTransactionManager() {
                    return new MyTransactionManager();
            }
    };
}