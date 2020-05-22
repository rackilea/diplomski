private static final Logger logger = LoggerFactory.getLogger(MessageListener.class);

    @Override
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage)message;
        try {
            if (objectMessage.getObject() instanceof NewUserMessage) {
                NewUserMessage newUserMessage = (NewUserMessage) objectMessage.getObject();
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}