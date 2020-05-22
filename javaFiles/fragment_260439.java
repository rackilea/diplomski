// Create a connection to the QueueManager
    qManager = "";    
    System.out.println("Connecting to queue manager: " + qManager);
    Hashtable props = new Hashtable();

    // Change the host name to your host name. Leave it as it is if 
    // queue manager is on the same machine
    props.put(CMQC.HOST_NAME_PROPERTY, "localhost"); 
    props.put(CMQC.PORT_PROPERTY, 1414);
    props.put(CMQC.CHANNEL_PROPERTY, "SYSTEM.DEF.SVRCONN");

    MQQueueManager qMgr = new MQQueueManager(qManager, props);