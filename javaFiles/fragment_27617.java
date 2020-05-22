import com.rabbitmq.jms.admin.RMQConnectionFactory;
import javax.jms.*;

/**
 *  docker run -d --hostname my-rabbit --name 
 *   some-rabbit  -p 5672:5672 -p 15672:15672 rabbitmq:3-management
 */
public class RabbitMqConsumer {
    public static void main(String[] args) throws Exception {
        RMQConnectionFactory connectionFactory = new RMQConnectionFactory();
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        connectionFactory.setHost("localhost");
        connectionFactory.setPort(5672);
        connectionFactory.setDeclareReplyToDestination(false);
        Connection connection = connectionFactory.createConnection();
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Queue queue = session.createQueue("TEST-QUEUE");
        drainQueue(session, queue);
    }

    protected static void drainQueue(Session session, Queue queue) throws Exception {
        MessageConsumer receiver = session.createConsumer(queue);
        Message msg = receiver.receiveNoWait();
        while (msg != null) {
            String msgBody = ((TextMessage) msg).getText();
            System.out.println("recieved" + msgBody);
            msg = receiver.receiveNoWait();
        }
    }
}