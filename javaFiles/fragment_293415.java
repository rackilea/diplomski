@Configuration
 class MyAMQConfig{
   public @Bean ActiveMQConnectionFactory createCF(){
      String brokerURI = parseOddXml(brokerConfigFile); // or whatever logic here.
      return new ActiveMQConnectionFactory(brokerURI);
   }
 }