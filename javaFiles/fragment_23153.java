@Configuration
// notice the missing @EnableAsync annotation
@EnableScheduling
@Profile("non-async")
public class NonAsyncConfiguration {

  // this configuration will be active as long as profile "non-async" is active

}