public class ConfigurationServiceProducer{

 @Produces
 public ConfigurationService produceConfigurationService(){
  //Instantiate and return the ConfigurationService accordingly.
  return new ConfigurationService();
 }
}