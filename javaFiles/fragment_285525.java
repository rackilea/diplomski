public void clearMessages() throws JMSException{
    Message message = null;
    do {
        message = consumer.receiveNoWait();
     if (message != null) message.acknowledge();
    }
    while (message != null);
}