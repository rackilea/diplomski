@Bean
public MQConnectionFactory mqConnectionFactory(){
  MQConnectionFactory connectionFactory = new MQConnectionFactory();
  connectionFactory.setHostName(); //mq host name
  connectionFactory.setPort(); // mq port
  connectionFactory.setQueueManager(); //mq queue manager
  connectionFactory.setChannel(); //mq channel name
  connectionFactory.setTransportType(1);
  connectionFactory.setSSLCipherSuite(); //tls cipher suite name
  return connectionFactory;
}


@Bean()
public DefaultMessageListenerContainer myMessageEventContainer() {
  DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
  container.setAutoStartup(true);
  container.setConnectionFactory(mqConnectionFactory);
  container.setDestinationName(//queue name//);
  container.setMessageListener(new MyEventListener());
  return container;
}