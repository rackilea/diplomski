OperatingSystemMXBean osBean = ManagementFactory
        .getPlatformMXBean(com.sun.management.OperatingSystemMXBean.class);  

// What % CPU load this current JVM is taking, from 0.0-1.0  
System.out.println(osBean.getProcessCpuLoad());  

// What % load the overall system is at, from 0.0-1.0  
System.out.println(osBean.getSystemCpuLoad());