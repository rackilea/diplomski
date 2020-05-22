@Configuration
@PropertySource("classpath:/com/appspecific/app.properties")
@Import(com.genericlib.BaseConfig.class)
public class AppConfig {
 @Inject BaseConfig baseConfig;

 @Bean
 public MyBean myBean() {
     // reference the base config context
     return new MyBean(baseConfig.getSomething());
 }
}