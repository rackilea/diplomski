@SpringBootApplication
public class So49512910Application {

    public static void main(String[] args) {
        SpringApplication.run(So49512910Application.class, args);
    }

    @Bean
    public Queue queue() {
        return new Queue("someQueue");
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange("topic_logs");
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with("whatever.topic.pattern.you.want.to.match");
    }

    @RabbitListener(queues = "someQueue")
    public void listener(String in) {
        System.out.println(in);
    }

}