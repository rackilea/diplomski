public <T extends BaseEvent> T recieveMessage()
    throws JMSException {

    connection.start(); // --->**added this line**
    Message message = consumer.receiveNoWait(); 

    if (message != null && !(message instanceof ObjectMessage)) {
        throw new IllegalArgumentException(
            "message object has to be of type ObjectMessage");
    }

    // Extract the object from the message
    return message == null ? null : (T) ((ObjectMessage) message).getObject();
}