@EnableBinding(Source.class)
@EnableConfigurationProperties(TcpSourceProperties.class)
public class MyTcpSourceConfiguration {

    @Autowired
    private Source channels;

    @Autowired
    private TcpSourceProperties properties;

    @Bean
    public TcpReceivingChannelAdapter adapter(
            @Qualifier("tcpSourceConnectionFactory") AbstractConnectionFactory connectionFactory) {
        TcpReceivingChannelAdapter adapter = new TcpReceivingChannelAdapter();
        adapter.setConnectionFactory(connectionFactory);
        adapter.setOutputChannelName("toMyProcessor");
        return adapter;
    }

    @ServiceActivator(inputChannel = "toMyProcessor", outputChannel = Source.OUTPUT)
    public byte[] myProcessor(byte[] fromTcp) {
        ...
    }

    @Bean
    public TcpConnectionFactoryFactoryBean tcpSourceConnectionFactory(
            @Qualifier("tcpSourceDecoder") AbstractByteArraySerializer decoder) throws Exception {
        TcpConnectionFactoryFactoryBean factoryBean = new TcpConnectionFactoryFactoryBean();
        factoryBean.setType("server");
        factoryBean.setPort(this.properties.getPort());
        factoryBean.setUsingNio(this.properties.isNio());
        factoryBean.setUsingDirectBuffers(this.properties.isUseDirectBuffers());
        factoryBean.setLookupHost(this.properties.isReverseLookup());
        factoryBean.setDeserializer(decoder);
        factoryBean.setSoTimeout(this.properties.getSocketTimeout());
        return factoryBean;
    }

    @Bean
    public EncoderDecoderFactoryBean tcpSourceDecoder() {
        EncoderDecoderFactoryBean factoryBean = new EncoderDecoderFactoryBean(this.properties.getDecoder());
        factoryBean.setMaxMessageSize(this.properties.getBufferSize());
        return factoryBean;
    }

}