import com.sun.messaging.ConnectionConfiguration;
import com.sun.messaging.ConnectionFactory;
import com.sun.messaging.Queue;
import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

public class TestJmsClientStandalone2 {

    public static void main( String[] args ) throws JMSException
    {
        ConnectionFactory connFactory = new ConnectionFactory();
        connFactory.setProperty(ConnectionConfiguration.imqAddressList, "remotehostip:7676");

        Queue myQueue = new Queue("myRemoteQueue");

        try (Connection connection = connFactory.createConnection(); 
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); 
                MessageProducer producer = session.createProducer(myQueue)) {

            Message message = session.createTextMessage("this is my test message");
            producer.send(message);
        }
    }
}