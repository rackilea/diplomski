@Configuration()
public class Config {
    @Bean
    public ServiceLocatorFactoryBean serviceLocatorFactoryBean() {
        ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
        serviceLocatorFactoryBean
                .setServiceLocatorInterface(MessageProcessorServiceFactory.class);
        return serviceLocatorFactoryBean;
    }

    @Bean("typeB")
    public MessageProcessorService typeBProcessorService() {
        return new MessageProcessorService() {

            @Override
            public void process(Message message) {
                System.out.println("Processing a B type message");
            }

        };
    }

    @Bean("typeA")
    public MessageProcessorService typeAProcessorService() {
        return new MessageProcessorService() {
            @Override
            public void process(Message message) {
                System.out.println("Processing an A type message");
            }
        };

    }

    @Bean
    public SomeService someService(){
        return new SomeService();
    }
}