@Configuration
 @ImportResource("classpath:/com/acme/database-config.xml")
 public class AppConfig {
     @Inject DataSource dataSource; // from XML

     @Bean
     public MyBean myBean() {
         // inject the XML-defined dataSource bean
         return new MyBean(this.dataSource);
     }
 }