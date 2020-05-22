@EnableBinding(Processor.class)
public class So41459187Application {

    public static void main(String[] args) {
        SpringApplication.run(So41459187Application.class, args);
    }

    @StreamListener(Processor.INPUT)
    @SendTo(Processor.OUTPUT)
    public String handle(String in) {
        return in.toUpperCase();
    }

    @Configuration
    public static class Config {

        @Bean
        public BeanPostProcessor channelConfigurer() {
            return new BeanPostProcessor() {

                @Override
                public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
                    return bean;
                }

                @Override
                public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
                    if ("input".equals(beanName)) {
                        ((AbstractMessageChannel) bean).addInterceptor(new ChannelInterceptorAdapter() {

                            @Override
                            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                                System.out.println("PreSend on INPUT: " + message);
                                return message;
                            }

                        });
                    }
                    else if ("output".equals(beanName)) {
                        ((AbstractMessageChannel) bean).addInterceptor(new ChannelInterceptorAdapter() {

                            @Override
                            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                                System.out.println("PreSend on OUTPUT: " + message);
                                return message;
                            }

                        });
                    }
                    return bean;
                }

            };
        }
    }

}