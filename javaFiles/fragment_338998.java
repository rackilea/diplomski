@Component
public class Example {

  private final RabbitTemplate rabbitTemplate;

  public Example(RabbitTemplate rabbitTemplate) {
      this.rabbitTemplate = rabbitTemplate;
  }

  @Override
  public void run(String... args) throws Exception {
       rabbitTemplate.convertAndSend(MessagingRabbitmqApplication.topicExchangeName, "foo.bar.baz", "Hello from RabbitMQ!");
  }