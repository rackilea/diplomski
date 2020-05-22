@ConfigurationProperties(prefix = "kafka")
public class MyKafkaProducerProperties {

  private Map<String, String> producer= new HashMap<String, String>();

  public Map<String, String> getProducer() {
    return this.producer;
  }
}