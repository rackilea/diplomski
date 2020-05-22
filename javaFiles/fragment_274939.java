@Configuration
@EnableRabbit
public class MessagingConfiguration {

    @Bean
    public CachingConnectionFactory rabbitConnectionFactory(RabbitProperties config) throws Exception {

        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.getRabbitConnectionFactory().setUri(RABBITMQ_ADDRESS);

        return connectionFactory;

    }

}