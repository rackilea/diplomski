// Transport parameters
final Map< String, Object > connectionParams = new HashMap< String, Object >();
connectionParams.put(TransportConstants.PORT_PROP_NAME, port);
connectionParams.put(TransportConstants.HOST_PROP_NAME, host);

final TransportConfiguration transportConfiguration = new TransportConfiguration(
    NettyConnectorFactory.class.getName(), connectionParams);

// this should be created only once and reused for the whole app lifecycle
connectionFactory = (ConnectionFactory) org.hornetq.api.jms.HornetQJMSClient
    .createConnectionFactoryWithoutHA(JMSFactoryType.QUEUE_CF, transportConfiguration);

final jmsQueue = HornetQJMSClient.createQueue(queueName)   

try {
    // connection is thread safe
    Connection connection = null;

    // session is not
    Session session = null;

    connection = connectionFactory.createConnection(user, password);
    connection.start();

   /* following objects must be propper to a thread (but should be reused if possible) */

    // Create a non transacted Session (no XA support outside of Java EE container)
    session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

    final MessageProducer producer = session.createProducer(jmsQueue);
    final ObjectMessage objectMessage = session.createObjectMessage();

    objectMessage.setObject(myMessageSerializableObject);

    producer.send(objectMessage);
}
finally {
    // Release resources
    try {
        if (session != null) {
          session.close();
        }
        if (connection != null) {
          connection.close();
        }
    }
    catch (final JMSException e) {
        LOG.warn("An error occurs while releasing JMS resources", e);
    }
}