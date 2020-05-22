@Configuration
@EnableJms
@ComponentScan("si.xxxx.yyyyy.jms")
public class JmsConfiguration{

    @Bean//(initMethod = "start", destroyMethod = "stop")
    public BrokerService brokerService() throws Exception {
        BrokerService brokerService = new BrokerService();
        brokerService.setPersistent(false);
        brokerService.setUseJmx(false);
        //brokerService.addConnector("vm://localhost:0");
        brokerService.addConnector("tcp://localhost:61616");
        brokerService.setBrokerName("broker");
        brokerService.setUseShutdownHook(false);
        return brokerService;
    }
    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory("tcp://localhost:61616");
        factory.setTrustAllPackages(true);
        return factory;
    }

    @Bean
    public ActiveMQQueue defaultDestination(){
        return new ActiveMQQueue("email");
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setDefaultDestination(defaultDestination());
        return jmsTemplate;
    }

    @Bean
    public DefaultMessageListenerContainer jmsListenerContainerFactory(ConnectionFactory connectionFactory){
        DefaultMessageListenerContainer containerFactory = new DefaultMessageListenerContainer();
        containerFactory.setConnectionFactory(connectionFactory);
        containerFactory.setDestination(defaultDestination());
        containerFactory.setMessageListener(messageListener());
        return containerFactory;
    }

    @Bean
    public MessageListener messageListener(){
        return new MessageListener();
    }
}