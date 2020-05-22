@Configuration
public class SomeConfig {

   @Autowired
   private Environment environment;

   @Bean
   public YourBeanType yourBeanType() {
       final String jvmProperty = environment.getProperty("instanceId");
       if(jvmProperty.equals("primary")) {
           return new YourBeanType(123);
       }
       else if(jvmProperty.equals("secondary")) {
           return new YourBeanType(456);
       }

       return new YourBeanType(-1); //return whatever is meaningfull here, or throw an exception

   }
}