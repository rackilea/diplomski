public class OpenMqClient implements MessageListener {

    private static Connection connection;
    private static final String mutex = "mutex"; 
    private Session session;
    private MessageConsumer responseConsumer;

    public OpenMqClient() {
        if(connection == null) {
            synchronized(mutex) {
                if(connection == null) {
                    String host = System.getProperty("foo", jmsBrokerUri);
                    QueueConnectionFactory cf = new QueueConnectionFactory();
                    cf.setProperty(ConnectionConfiguration.imqAddressList, host);

                    // Setup connection
                    connection = cf.createConnection();
                    connection.start();
                }
            }
        }
    }

    public void sendMessage(String messageContent, String jmsBrokerUri, String queueName) {
        try {
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            // Setup queue and producer
            Queue queue = session.createQueue(queueName);
            MessageProducer producer = session.createProducer(queue);

            // Reply destination
            Queue responseQueue = session.createTemporaryQueue();
            responseConsumer = session.createConsumer(responseQueue);
            responseConsumer.setMessageListener(this);

            // Create message
            TextMessage textMessage = session.createTextMessage();
            textMessage.setJMSReplyTo(responseQueue);
            textMessage.setJMSCorrelationID("test0101");
            textMessage.setText(messageContent);

            producer.send(textMessage);
            System.out.println("Message sent");
        } catch (JMSException e) {
            e.printStackTrace();
            System.out.println("JMSException in Sender");
        }
    }

    @Override
    public void onMessage(Message arg0) {
        // do stuff
        new Thread(
            new Runnable() {
                @Override
                public void run() {
                    if(session != null)
                        try {
                            session.close();
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }               
                }
            }
        ).start();
    }
}