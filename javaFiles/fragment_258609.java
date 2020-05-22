@Configuration
public class RabbitConfig {

    @Bean
    @Scope("prototype")
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(SimpleRabbitListenerContainerFactory factory, ObjectMapper objectMapper) {
        factory.setMessageConverter(jsonToMapMessageConverter(objectMapper));
        return factory;
    }

    @Bean
    public MessageConverter jsonToMapMessageConverter(ObjectMapper objectMapper) {
        Jackson2JsonMessageConverter messageConverter = new ImplicitJsonMessageConverter(objectMapper);
        DefaultClassMapper classMapper = new DefaultClassMapper();
        classMapper.setTrustedPackages("*");
        classMapper.setDefaultType(Map.class);
        messageConverter.setClassMapper(classMapper);
        return messageConverter;
    }

    public static class ImplicitJsonMessageConverter extends Jackson2JsonMessageConverter {    
        public ImplicitJsonMessageConverter(ObjectMapper jsonObjectMapper) {
            super(jsonObjectMapper, "*");
        }    
        @Override
        public Object fromMessage(Message message) throws MessageConversionException {
            message.getMessageProperties().setContentType("application/json");
            return super.fromMessage(message);
        }
    }
}