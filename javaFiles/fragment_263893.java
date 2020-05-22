@Configuration
@Getter
@Setter
public class QueueConfig {

  private String name;
  private String port;
  private String protocol;
  private String queue;
  private String sampleRateMinutes;

}


@Configuration
@Getter
@Setter
@ConfigurationProperties(prefix = "br.net.enterprise")
public class MyConfig {
  Map<Integer, QueueConfig> server;
}