@EnableJms
@Configuration class JmsListenerConfig implements JmsListenerConfigurer {

 Logger logger = LoggerFactory.getLogger(Receiver.class);

 @Bean
 public DefaultMessageHandlerMethodFactory handlerMethodFactory() {
    DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
    factory.setMessageConverter(messageConverter());
    return factory;
 }

 @Bean
 public MessageConverter messageConverter() {
    return new MappingJackson2MessageConverter();
 }

 @Override
 public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
    registrar.setMessageHandlerMethodFactory(handlerMethodFactory());
 }
}