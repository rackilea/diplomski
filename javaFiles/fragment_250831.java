import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ConfigurationException;
import org.apache.log4j.Logger;

public class ActiveMQProducer2 {

    private static final Logger LOGGER = Logger.getLogger(ActiveMQProducer2.class);
    private Connection connection;
    private Session session;
    String activeMQConnection;
    Map<String, Destination> destinations = Collections.synchronizedMap(new HashMap<String, Destination>());
    private MessageProducer producer;
    Thread shutdownHook = new Thread(new Runnable() {
        @Override
        public void run() {
            close();
        }
    });

    public ActiveMQProducer2() throws ConfigurationException, JMSException {
        activeMQConnection = ActiveMQPropertyManagerFactory.getInstance().getString("active.mq.url");
        setupActiveMQ();
        Runtime.getRuntime().addShutdownHook(shutdownHook);
    }

    public void setupActiveMQ() throws JMSException {
        close();
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(activeMQConnection);
        factory.setRejectedTaskHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        connection = factory.createConnection();
        connection.start();
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        producer = session.createProducer(session.createTemporaryQueue());
    }

    @Override
    protected void finalize() throws Throwable {
        close();
        super.finalize();
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (Exception e) {
            }
            connection = null;
        }
    }

    public void getConnection() throws JMSException {
        if (connection == null || session == null) {
            setupActiveMQ();
        }
    }

    public Destination getDestination(String queueName) throws JMSException {
        getConnection();
        Destination destination = destinations.get(queueName);
        if (destination == null) {
            destination = session.createQueue(queueName);
            destinations.put(queueName, destination);
        }
        return destination;
    }

    public <T extends Serializable> T sendToActiveMQ(String queueName, T t) throws JMSException {
        Destination destination = getDestination(queueName);
        ObjectMessage message = session.createObjectMessage(t);
        producer.send(destination, message);
        return null;
    }

    public void sendMessageToActiveMQ(String queueName, String message) throws JMSException {
        Destination destination = getDestination(queueName);
        TextMessage toSend = session.createTextMessage(message);
        producer.send(destination, toSend);
    }
}