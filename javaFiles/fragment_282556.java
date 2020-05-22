@TransactionAttribute(TransactionAttributeType.NOTSUPPORTED)
public void add(String participant, String password, List<Long> documents) throws OgnivoException {

    try (Connection connection = connectionFactory.createConnection();
         Session session = connection.createSession();
         // session.start() not required
         MessageProducer sender = session.createProducer(queue)) {
        logger.debug("requests to process " + documents);

        for (Long id : documents) {
            Message msg = msg = session.createMessage();
            msg.setStringProperty("participant", participant);
            msg.setStringProperty("password", password);
            msg.setLongProperty("request", id);
            sender.send(msg);
        }

    } catch (JMSException e) {
        throw new JmsAppException(e);
    }
    // Don't catch throwable because it hides bugs
}