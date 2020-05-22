@Configuration
class YourActiveMQConnectionFactoryConfiguration {


    @Bean
    public ConnectionFactory jmsConnectionFactory() {
        return createFactory(); //do whatever you need to here
    }
}