public class SizeOfMainMemory {

    public static void main(String[] args) {
        com.sun.management.OperatingSystemMXBean mxbean = (com.sun.management.OperatingSystemMXBean) ManagementFactory
                .getOperatingSystemMXBean();
        System.out.println(mxbean.getTotalPhysicalMemorySize()/1024/1024);
    }

}