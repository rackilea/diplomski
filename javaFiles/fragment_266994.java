@Configuration
public class MyConfig {

  @Bean
  public SingleConnectionFactory connectionFactory() {
      ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
      ((ActiveMQConnectionFactory) connectionFactory)
            // See http://activemq.apache.org/objectmessage.html why we set trusted packages
            .setTrustedPackages(new ArrayList<String>(Arrays.asList("com.mydomain", "java.util")));
    return new SingleConnectionFactory(connectionFactory);
}

  @Bean
  @Scope("prototype")
  public JmsTemplate jmsTemplate() {
      return new JmsTemplate(connectionFactory());
  }

  @Bean
  public Queue myQueue() throws JMSException {
      Connection connection = connectionFactory().createConnection();
      connection.start();
      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      Queue queue = session.createQueue("message-updates");
      return queue;
  }
}

@Component
public class MyQueueImpl implements MyQueue {

  @Inject
  private JmsTemplate jmsTemplate;

  @Inject
  private Queue myQueue;

  @PostConstruct
  public void init() {
   jmsTemplate.setReceiveTimeout(JmsTemplate.RECEIVE_TIMEOUT_NO_WAIT);
  }

  @Override
  public void enqueue(Widget widget) {
      jmsTemplate.send(myQueue, new MessageCreator() {
          @Override
          public Message createMessage(Session session) throws JMSException {
              return session.createObjectMessage(widget);
          }
      });
  }

  @Override
  public Optional<Widget> dequeue() {
    Optional<Widget> widget = Optional.empty();
    ObjectMessage message = (ObjectMessage) jmsTemplate.receive(myQueue);
    try {
        if (message != null) {
            widget = Optional.ofNullable((Widget) message.getObject());
            message.acknowledge();
        }
    } catch (JMSException e) {
        throw new UncategorizedJmsException(e);
    }

    return widget;
  }
}