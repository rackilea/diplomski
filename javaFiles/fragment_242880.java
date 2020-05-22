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
    public Binding binding() {
        return new Binding("someQueue", DestinationType.QUEUE, "topic_logs", "rk.pattern", null);
    }

    @RabbitListener(queues = "someQueue")
    public void listener(String in) {
        System.out.println(in);
    }

}