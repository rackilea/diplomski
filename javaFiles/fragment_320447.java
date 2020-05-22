Hashtable props = new Hashtable();
props.put(CMQC.HOST_NAME_PROPERTY, "mymq.server.com"); 
props.put(CMQC.PORT_PROPERTY, 1414);
props.put(CMQC.CHANNEL_PROPERTY, "SYSTEM.DEF.SVRCONN");
props.put(CMQC.USER_ID_PROPERTY, "myusername";)

MQQueueManager qMgr = new MQQueueManager(qManager, props);