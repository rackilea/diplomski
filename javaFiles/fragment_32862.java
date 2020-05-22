public class JmsAdapter implements MessageListener, ExceptionListener
{
    private ConnectionFactory connFactory = null;
    private Connection conn = null;
    private Session session = null;

    public void receiveMessages() 
    {
        try
        {
            this.session = this.conn.createSession(true, Session.SESSION_TRANSACTED);

            this.conn.setExceptionListener(this);

            Destination destination = this.session.createQueue("SOME_QUEUE_NAME");

            this.consumer = this.session.createConsumer(destination);

            this.consumer.setMessageListener(this);

            this.conn.start();
        } 
        catch (JMSException e) 
        {
            //Handle JMS Exceptions Here
        }
    }

    @Override
    public void onMessage(Message message) 
    {
        try
        {
            //Do Message Processing Here

            //Message sucessfully processed...  Go ahead and commit the transaction.
            this.session.commit();
        }
        catch(SomeApplicationException e)
        {
            //Message processing failed.
            //Do whatever you need to do here for the exception.

            //NOTE: You may need to check the redelivery count of this message first
            //and just commit it after it fails a predefined number of times (Make sure you
            //store it somewhere if you don't want to lose it).  This way you're process isn't
            //handling the same failed message over and over again.
            this.session.rollback()
        }
    }
}