@Override
public void process(Exchange exchange)
    throws Exception {

    QueueConnection m_connection = this.connectionFactory.createQueueConnection();
    //m_connection.start();
    boolean transacted = false;

    QueueSession session = m_connection.createQueueSession(transacted, QueueSession.AUTO_ACKNOWLEDGE);
    TextMessage outMessage = session.createTextMessage();
    outMessage.setText(exchange.getIn().getBody());
    MQQueue mq = new MQQueue(
        "queue://Different_QueueManager_in_Cluster/TEST.REPLY");
    QueueSender queueSender = session.createSender((MQQueue) mq);
    queueSender.send(outMessage);

    /* producerTemplate.send("wmq:" + "queue://Different_QueueManager_in_Cluster/TEST.REPLY", exchange); */
}