@Configuration
@EnableIntegration
@Profile("integration")
public class IntegrationConfiguration {
    @Autowired
    UserService userService;

    @Bean
    public DirectChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    public DirectChannel replyChannel() {
        return new DirectChannel();
    }

    @Bean
    public HttpRequestHandlingMessagingGateway httpGate() {
        HttpRequestHandlingMessagingGateway gateway = new HttpRequestHandlingMessagingGateway(true);
        RequestMapping requestMapping = new RequestMapping();
        requestMapping.setMethods(HttpMethod.POST);
        requestMapping.setPathPatterns("/users");
        gateway.setRequestPayloadType(User.class);
        gateway.setRequestMapping(requestMapping);
        gateway.setRequestChannel(inputChannel());
        gateway.setReplyChannel(replyChannel());
        return gateway;
    }

    @Bean
    public IntegrationFlow flow(UserService userService) {
        return IntegrationFlows.from(httpGate()).handle((p, h) -> userService.create((User) p))
                .enrichHeaders(
                        c -> c.header(org.springframework.integration.http.HttpHeaders.STATUS_CODE, HttpStatus.CREATED))
                .get();
    }
}