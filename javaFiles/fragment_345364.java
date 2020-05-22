import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectInstance;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import java.lang.management.ManagementFactory;
import java.util.Iterator;
import java.util.Set;

class GetMBeans {
    public static void main(final String[] args) throws Exception {
       final JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
       final JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
       final MBeanServerConnection connection = jmxc.getMBeanServerConnection();

       Set<ObjectInstance> instances = connection.queryMBeans(null, null);
       Iterator<ObjectInstance> iterator = instances.iterator();
       while (iterator.hasNext()) {
           ObjectInstance instance = iterator.next();
           System.out.println(instance.getClassName() + " " + instance.getObjectName());
       }
    }
}