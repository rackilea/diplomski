@SpringBootApplication
public class So49323291Application {

    public static void main(String[] args) {
        SpringApplication.run(So49323291Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(RabbitListenerEndpointRegistry registry, CachingConnectionFactory cf,
            RabbitTemplate template) {
        return args -> {
            cf.setUsername("foo");
            cf.setPassword("bar");
            registry.start();
            doSends(template);
            registry.stop();
            cf.resetConnection();
            cf.setUsername("baz");
            cf.setPassword("qux");
            registry.start();
            doSends(template);
        };
    }

    public void doSends(RabbitTemplate template) {
        while (true) {
            try {
                template.convertAndSend("foo", "Hello");
                Thread.sleep(5_000);
            }
            catch (Exception e) {
                e.printStackTrace();
                break;
            }
        }
    }

    @RabbitListener(queues = "foo", autoStartup = "false")
    public void in(Message in) {
        System.out.println(in);
    }

}