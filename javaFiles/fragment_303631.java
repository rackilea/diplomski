public class MyConsumer extends DefaultConsumer {


    public void handleDelivery(String consumerTag, Envelope envelope,
            BasicProperties properties, byte[] body) throws java.io.IOException {

        /// byte[] body = body Message
        /// here you have your message

        getChannel().basicAck(envelope.getDeliveryTag(), false);
    }


}