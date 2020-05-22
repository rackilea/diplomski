public class GetFlags {

    public static void main(String[] args) throws MalformedObjectNameException {

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();

        ObjectName name = ObjectName.getInstance("com.sun.management:type=DiagnosticCommand");

        DiagnosticCommand_vmFlags vmFlags = JMX.newMXBeanProxy(server, name, DiagnosticCommand_vmFlags.class);

        System.out.println("Short version");
        System.out.println(vmFlags.vmFlags());

        System.out.println("Verbose version");
        System.out.println(vmFlags.vmFlags("-all"));
    }


    public interface DiagnosticCommand_vmFlags {

        public String vmFlags(String... args);

    }
}