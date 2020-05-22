public class ConfigServiceTest implements ConfigurationService{

    @Override
    public Configuration getConfiguration() {
        Configuration conf = mock(Configuration.class);
        ActiveMq amq = mock(ActiveMq.class);

        when(amq.getQueueName()).thenReturn("test");
        when(amq.getBrokerUrl()).thenReturn("http://127.0.0.1:61616?soTimeout=1000");
        when(conf.getActiveMq()).thenReturn(amq);

        return conf;
    }
    //other methods just allowed to return null
 }