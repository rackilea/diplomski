service = new ObjectName(
                "com.bea:Name=RuntimeService,Type=weblogic.management.mbeanservers.runtime.RuntimeServiceMBean");

        InitialContext ctx = new InitialContext();
        MBeanServer mBeanServer = (MBeanServer) ctx.lookup("java:comp/env/jmx/runtime");

        ObjectName rt = (ObjectName) mBeanServer.getAttribute(service, "ServerRuntime");
        listenAddress = (String) mBeanServer.getAttribute(rt, "ListenAddress");
        server = listenAddress.substring(0, listenAddress.indexOf("/"));
        port = (Integer)mBeanServer.getAttribute(rt, "ListenPort");