@EnableConfigurationProperties(value =
                                   {
                                       StorageConfiguration.class
                                   }
)
@EnableAutoConfiguration(exclude = {
    DataSourceAutoConfiguration.class
    , VelocityAutoConfiguration.class
})
@EntityScan(basePackages = {
    "my.entities.path"
})
@SpringBootApplication
public class SpringBootApplicationForTest {
  public static void main(String[] args) {
    SpringApplication.run(SpringBootApplicationForTest.class, args);
  }

}