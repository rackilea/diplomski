@Configuration
@EnableAsync
@EnableScheduling
@Profile("!non-async")
public class AsyncConfiguration implements AsyncConfigurer {

  // this configuration will be active as long as profile "non-async" is not (!) active

}