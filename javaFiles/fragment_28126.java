@SpringBootApplication
public class So49854747Application {

    public static void main(String[] args) {
        SpringApplication.run(So49854747Application.class, args).close();
    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate template, FanoutExchange exchange) {
        return args -> {
            template.convertAndSend(exchange.getName(), "", "foo");
            Thread.sleep(10_000);
        };
    }

    @Bean
    public Queue anonQueue() {
        return new AnonymousQueue();
    }

    @Bean
    public FanoutExchange exchange() {
        return new FanoutExchange("so49854747");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(anonQueue()).to(exchange());
    }

    @RabbitListener(queues = "#{anonQueue.name}")
    public void listen(String in) {
        System.out.println(in);
    }

}