MBeanServer mbeanServer = ManagementFactory
                .getPlatformMBeanServer();


        //giving name for service
        ObjectName objectName = new ObjectName("bean:name=logService");

        String str = (String) mbeanServer.getAttribute (objectName, "logString");
        System.out.println(str);