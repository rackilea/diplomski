ConnectionFactory conFactory = (ConnectionFactory) ic.lookup("java:/ConnectionFactory");//customize the jndi to match your server
Connection connection = conFactory.createConnection();
Queue myqueue = ic.lookup("java:/jms/queue/MyQueue");
Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
String messageSelector = "MY_MSG_PROPERTY = 'MY_FILTER_VALUE'";
Consumer consumer = session.createConsumer(myqueue, messageSelector);

consumer.setMessageListener(new MessageListener() {
    @Override
    public void onMessage(Message message) {
        //handle you message here
    }
});