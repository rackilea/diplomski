@Rule
private static final ExternalResource embeddedAMQPBroker = new ExternalResource() {
    Broker broker;

    @Override
    protected void before() throws Throwable {
        BrokerOptions brokerOptions = new BrokerOptions();
        brokerOptions.setConfigProperty("qpid.amqp_port", "55672");
        broker = new Broker();
        broker.startup(brokerOptions);
    }

    @Override
    protected void after() {
        broker.shutdown();
    }
};