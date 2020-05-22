import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ConfigurationException;
import org.apache.log4j.Logger;

public class ActiveMQProducer {

    private static final Logger LOGGER = Logger.getLogger(ActiveMQProducer.class);
    private Connection connection;
    private Session session;
    String activeMQConnection;
    Map<String, MessageProducer> producers = Collections.synchronizedMap(new HashMap<String, MessageProducer>());
    Thread shutdownHook = new Thread(new Runnable() {
        @Override
        public void run() {
            close();
        }
    });

    public ActiveMQProducer() throws ConfigurationException, JMSException {
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

    public MessageProducer getProducer(String queueName) throws JMSException {
        getConnection();
        MessageProducer producer = producers.get(queueName);
        if (producer == null) {
            Queue queue = session.createQueue(queueName);
            producer = session.createProducer(queue);
            producers.put(queueName, producer);
        }
        return producer;
    }

    public <T extends Serializable> T sendToActiveMQ(String queueName, T t) throws JMSException {
        MessageProducer producer = getProducer(queueName);
        ObjectMessage message = session.createObjectMessage(t);
        producer.send(message);
        return null;
    }

    public void sendMessageToActiveMQ(String queueName, String message) throws JMSException {
        MessageProducer producer = getProducer(queueName);
        TextMessage toSend = session.createTextMessage(message);
        producer.send(toSend);
    }
}