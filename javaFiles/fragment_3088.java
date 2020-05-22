Hashtable<String, Comparable<?>> props = new Hashtable<String, Comparable<?>>();

props.put(MQConstants.TRANSPORT_PROPERTY, MQConstants.TRANSPORT_MQSERIES_CLIENT);
props.put(MQConstants.HOST_NAME_PROPERTY, hostname);
props.put(MQConstants.CHANNEL_PROPERTY, channel);
props.put(MQConstants.PORT_PROPERTY, new Integer(port));
props.put(MQConstants.USER_ID_PROPERTY, userName);
props.put(MQConstants.USE_MQCSP_AUTHENTICATION_PROPERTY, Boolean.TRUE);
props.put(MQConstants.PASSWORD_PROPERTY, password);

MQQueueManager qm = new MQQueueManager("MY.QM", props);

PCFAgent agent = new PCFAgent(qm);