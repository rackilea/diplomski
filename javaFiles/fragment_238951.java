@Configuration
@EnableConfigurationProperties(MyKafkaProducerProperties.class)
public class FactoryBeanAppConfig {

  @Bean
  public Producer<String, String> producer(MyKafkaProducerProperties kafkaProperties) throws Exception {

    Properties properties = new Properties();

    for ( String key : kafkaProperties.getProducer().keySet() ) {
     properties.setProperty(key, kafkaProperties.getProducer().get(key));
    }

    Producer<String, String> producer = new KafkaProducer<String, String>(properties);
    return producer;
  }
}