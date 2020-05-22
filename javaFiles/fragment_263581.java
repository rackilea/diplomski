public void sendMessage() throws JMSException {
    QueueConnection connection = null;

    try {
        connection = connectionFactory.createQueueConnection();
        QueueSession session = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
        QueueSender sender = session.createSender(requestQueue);
        TextMessage message = session.createTextMessage(text);
        sender.send(message);
    } finally {
        if (connection != null) try {
            connection.close();
        } catch (JMSException e) {
            // Log or ignore.
        }
    }
}