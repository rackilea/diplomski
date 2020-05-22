@SpringBootApplication
public class So59760805Application {

    public static void main(String[] args) {
        SpringApplication.run(So59760805Application.class, args);
    }

    @Bean
    public SimpleMessageListenerContainer container(ConnectionFactory cf) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cf);
        container.setQueueNames("foo");
        container.setMessageListener(new MessageListenerAdapter(new MyListener()));
        return container;
    }

    @Bean
    public MyExtendedTemplate template(ConnectionFactory cf) {
        return new MyExtendedTemplate(cf);
    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate template) {
        return args -> System.out.println(template.convertSendAndReceive("", "foo", "test"));
    }

}

class MyListener {

    public String handleMessage(String in) {
        return in.toUpperCase();
    }

}

class MyExtendedTemplate extends RabbitTemplate {

    MyExtendedTemplate(ConnectionFactory cf) {
        super(cf);
    }

    @Override
    public void onMessage(Message message) {
        System.out.println("Response received (before conversion): " + message);
        super.onMessage(message);
    }

}