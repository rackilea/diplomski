@Resource(lookup = "jms/JmsFactory")
private ConnectionFactory jmsFactory;

@Resource(lookup = "jms/JmsQueue")
private Queue jmsQueue;

public void send() {

    TextMessage message;

    try (Connection connection = jmsFactory.createConnection();
         Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
         MessageProducer producer = session.createProducer(jmsQueue)) {

        message = session.createTextMessage();
        message.setText("Hello World!");

        // Don't pass in destination again since you set it in createProducer()
        producer.send(message);   

        // ...