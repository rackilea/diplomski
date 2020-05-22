import java.util.HashMap;
import java.util.Map;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.TopicViewMBean;

public class JMXGetDestinationInfos {

    public static void main(String[] args) throws Exception {
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        Map<String, String[]> env = new HashMap<>();
        String[] creds = { "admin", "admin" };
        env.put(JMXConnector.CREDENTIALS, creds);
        JMXConnector jmxc = JMXConnectorFactory.connect(url, env);
        MBeanServerConnection conn = jmxc.getMBeanServerConnection();

        ObjectName activeMq = new ObjectName("org.apache.activemq:type=Broker,brokerName=localhost");

        BrokerViewMBean mbean = MBeanServerInvocationHandler.newProxyInstance(conn, activeMq, BrokerViewMBean.class,
                true);
        for (ObjectName name : mbean.getTopics()) {
            if (("YOUR_TOPIC_NAME".equals(name.getKeyProperty("destinationName")))) {
                TopicViewMBean topicMbean = MBeanServerInvocationHandler.newProxyInstance(conn, name,
                        TopicViewMBean.class, true);
                System.out.println(topicMbean.getConsumerCount());
            }
        }
    }
}