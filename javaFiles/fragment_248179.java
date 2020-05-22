import java.lang.management.ManagementFactory;
import javax.management.*;

public class Main {
  public static void main(String[] args) {
    try {
      MBeanServer server = ManagementFactory.getPlatformMBeanServer();
      ObjectName mbeanName = new ObjectName("com.mydomain", "type", "login");
      server.registerMBean(
        new StandardMBean(new Login("John Doe", "password"), LoginMBean.class), mbeanName);
      MBeanInfo mbeanInfo = server.getMBeanInfo(mbeanName);
      MBeanAttributeInfo[] attrs = mbeanInfo.getAttributes();
      for (MBeanAttributeInfo attr: attrs) {
        Descriptor desc = attr.getDescriptor();
        boolean obfuscated = false;
        if (desc.getFieldValue("obfuscated") != null) {
          obfuscated = (Boolean) desc.getFieldValue("obfuscated");
        }
        if (obfuscated) System.out.printf("field '%s' is obfuscated%n", attr.getName());
        else {
          Object value = server.getAttribute(mbeanName, attr.getName());
          System.out.printf("value of field '%s' is '%s'%n", 
            attr.getName(), value == null ? "null" : value.toString());
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}