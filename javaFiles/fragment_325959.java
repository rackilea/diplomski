@Bean
    @Autowired
    @ConditionalOnExpression("'${mongo.transactions}'=='enabled'")
    MongoTransactionManager mongoTransactionManager(MongoDbFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }