public class PhysicalMemory {
    public static void main(String[] args) {
        String[] attr={ "TotalPhysicalMemorySize", "FreePhysicalMemorySize"};
        OperatingSystemMXBean op = ManagementFactory.getOperatingSystemMXBean();
        List<Attribute> al;
        try {
            al = ManagementFactory.getPlatformMBeanServer()
                                  .getAttributes(op.getObjectName(), attr).asList();
        } catch (InstanceNotFoundException | ReflectionException ex) {
            Logger.getLogger(PhysicalMemory.class.getName()).log(Level.SEVERE, null, ex);
            al = Collections.emptyList();
        }
        for(Attribute a: al) {
            System.out.println(a.getName()+": "+a.getValue());
        }
    }
}