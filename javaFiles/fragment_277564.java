public class AmqpReceiveServiceIntegrationTest {

  @ClassRule
  public static GenericContainer rabbitmqContainer =
    new GenericContainer<>("rabbitmq:3.7").withExposedPorts(5672);

  static ConnectionFactory factory;
  static Connection connection;
  static Channel sendChannel;

  @BeforeClass
  public static void beforeClass() throws IOException, TimeoutException {
    factory = new ConnectionFactory();
    factory.setHost(rabbitmqContainer.getContainerIpAddress());
    factory.setPort(rabbitmqContainer.getFirstMappedPort());

    connection = factory.newConnection();

    sendChannel = connection.createChannel();
    sendChannel.queueDeclare("hello", false, false, false, null);
  }

  @Test
  public void sendIsOk() {
    sendChannel.basicPublish("", "hello", null, "Hello World!.getBytes()); 

    // assertions ...
  }
}