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

class MBeanClient {
    public static void main(final String[] args) throws Exception {
       final JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
       final JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
       final MBeanServerConnection connection = jmxc.getMBeanServerConnection();

       final IProxy proxy = (IProxy) MBeanServerInvocationHandler.newProxyInstance(connection, new ObjectName("org.jacoco:type=Runtime"), IProxy.class, false);

       final byte[] data = proxy.getExecutionData(false);
       System.out.println("Got " + data.length + " bytes");
    }

    public interface IProxy {
        String getVersion();
        String getSessionId();
        void setSessionId(String id);
        byte[] getExecutionData(boolean reset);
        void dump(boolean reset);
        void reset();
    }
}