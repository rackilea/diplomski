/**
 * The bean name of the {@link org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory}
 * to use to create the message listener container responsible to serve this endpoint.
 * <p>If not specified, the default container factory is used, if any.
 * @return the {@link org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory}
 * bean name.
 */
String containerFactory() default "";