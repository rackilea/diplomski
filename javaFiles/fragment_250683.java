@Configuration
@Profile("profileA")
@PropertySource({"classpath:application-profileA.properties"})
public class ConfigurationProfileA{
 @Value("${target.url}")
 String url;
 @Value("${target.usr}")
 String usr;
 @Value("${target.key}")
 String key;

 @Bean
 public TargetConnector connector() {
   return new TargetConnector(url, usr, key);
 }
}