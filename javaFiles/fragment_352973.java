@Bean
    @Autowired
    public JmsComponent activemq(final ConnectionFactory jmsConnectionFactory, final PlatformTransactionManager jmsTransactionManager) {
        final ActiveMQComponent activemq = new ActiveMQComponent();
        activemq.setConnectionFactory(jmsConnectionFactory);
        activemq.setTransactionManager(jmsTransactionManager);
        activemq.setTransacted(true);
        return activemq;
    }