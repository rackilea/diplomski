import java.util.Set;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.advisory.DestinationSource;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;

public class AdvisorySupportGetAllDestinationsNames {

    public static void main(String[] args) throws JMSException {
        Connection conn = null;
        try {
            ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
            conn = cf.createConnection();
            conn.start();
            DestinationSource destinationSource = ((ActiveMQConnection) conn).getDestinationSource();
            Set<ActiveMQQueue> queues = destinationSource.getQueues();
            Set<ActiveMQTopic> topics = destinationSource.getTopics();
            System.out.println(queues);
            System.out.println(topics);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                }
            }
        }
    }
}