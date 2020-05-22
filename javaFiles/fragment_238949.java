@Configuration
@EnableConfigurationProperties(MyKafkaProducerProperties.class)
public class FactoryBeanAppConfig {

  @Bean
  public Producer<String, String> producer(MyKafkaProducerProperties kafkaProperties) throws Exception {
    Properties properties = new Properties();
    properties.setProperty("Foo", kafkaProperties.getFoo());
    properties.setProperty("Bar", kafkaProperties.getBar());
    Producer<String, String> producer = new KafkaProducer<String, String>(properties);
    return producer;
  }
}