MQEnvironment.channel = 'SYSTEM.DEF.SVRCONN'; //Replace with your channel name
 MQEnvironment.hostname = 'localhost'; //Replace with your host name
 MQEnvironment.port = 1414; //Replace with your port number

 MQQueueManager QM_OBJ= new MQQueueManager("");

 String QueueManagerName = QM_OBJ.getAttributeString(MQC.MQCA_Q_MGR_NAME, 100).trim();