jade.core.Runtime rt = jade.core.Runtime.instance();

    Properties properties = new Properties();
    properties.put("local-port", "8858");
    properties.put("port", "8858");
    properties.put("host", "127.0.0.1");
    properties.put("local-host", "127.0.0.1");
    .... other parameters
    properties.put("jade_core_messaging_MessageManager_poolsize", "100");

    ProfileImpl p = new ProfileImpl(properties);
    rt.setCloseVM(true);
    AgentContainer agentContainer = rt.createMainContainer(p);

    AgentController ac = agentContainer.createNewAgent("YourAgent", YourAgent.class.getName(), new Object[]{});
    ac.start();