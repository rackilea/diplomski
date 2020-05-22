import javax.management.*;
import javax.management.remote.*;
conn = null;
try {
    url = new JMXServiceURL("service:jmx:rmi://njw810/jndi/rmi://njw810:1090/jmxconnector");
    conn = JMXConnectorFactory.connect(url);
    server = conn.getMBeanServerConnection();
    objectName = new ObjectName("jboss.web:type=Connector,address=*,port=*");    // HTTP/1.1
    println server.queryNames(objectName, Query.match(Query.attr("protocol"), Query.value("HTTP/1.1"))).iterator().next().getKeyProperty("port");
} finally {
    try { conn.close(); println "Connection Closed"; } catch (Exception e) {}
}