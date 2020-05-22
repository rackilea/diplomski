@Before
public void setUp() throws Exception {
    super.setUp();
    brokerSvc = new BrokerService();
    brokerSvc.setBrokerName("TestBroker");
    brokerSvc.addConnector("tcp://localhost:61616");
    brokerSvc.start();
}