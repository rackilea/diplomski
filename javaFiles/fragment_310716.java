@Configuration
@EnableIntegration
@EnableRetry
@ComponentScan
public class HttpFlowSample {

    @Bean
    public MessageChannel input() {
        return new DirectChannel();
    }

    @Bean
    public MessagingGatewaySupport httpInboundGateway() {
        HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway();
        RequestMapping mapping = new RequestMapping();
        mapping.setPathPatterns("/foo");
        gateway.setRequestMapping(mapping);
        gateway.setRequestChannel(this.input());
        return gateway;
    }


    @MessageEndpoint
    public static class MyService {

        @ServiceActivator(inputChannel = "input")
        @Retryable
        public String serviceMethod(Object payload) {
            //Do business logic
            return "OK";
        }

    }

}