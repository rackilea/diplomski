@Override 
@Transactional
public void onMessage(Message amqpMessage, Channel channel)
            throws Exception {
    //..some code goes here - I want it to be in spring transaction
}