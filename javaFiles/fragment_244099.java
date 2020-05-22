package rabbitExample;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * Demonstrates reading messages from two exchanges via a single queue monitored
 * by a single thread.
 * 
 */
public class MultiExchangeReadTest implements Runnable {

private final String exch1 = "my.topic.exchange";
private final String exch2 = "my.fanout.exchange";
private final Channel channel;
private final QueueingConsumer consumer;

public MultiExchangeReadTest(final String mqHost) throws Exception {

    // Connect to server
    System.out.println("Connecting to host " + mqHost);
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost(mqHost);
    Connection connection = factory.newConnection();
    channel = connection.createChannel();

    // Declare exchanges; use defaults for durable etc.
    channel.exchangeDeclare(exch1, "topic");
    channel.exchangeDeclare(exch2, "fanout");

    // Get a new, unique queue name
    final String queue = channel.queueDeclare().getQueue();

    // Bind the queue to the exchanges; topic gets non-empty routing key
    channel.queueBind(queue, exch1, "my.key");
    channel.queueBind(queue, exch2, "");

    // Configure the channel to fetch one message at a time, auto-ACK
    channel.basicQos(1);
    consumer = new QueueingConsumer(channel);
    channel.basicConsume(queue, true, consumer);
}

public void run() {
    // Reads messages until interrupted
    try {
        while (true) {
            // Wait for a message
            System.out.println("Awaiting message");
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            // Show contents using default encoding scheme
            String body = new String(delivery.getBody());
            System.out.println("Message from exch "
                    + delivery.getEnvelope().getExchange() + ", key '"
                    + delivery.getEnvelope().getRoutingKey() + "':\n"
                    + body);
        } // while
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

public static void main(String[] args) throws Exception {
    if (args.length != 1) {
        System.err
                .println("Usaage: MultiExchangeReadTest.main mq-host-name");
    } else {
        MultiExchangeReadTest multiReader = new MultiExchangeReadTest(
                args[0]);
        multiReader.run();
    }
}
}