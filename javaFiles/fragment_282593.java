@Configuration
@Import(Calling.class)
public class MyConfig {
   @Bean
   public ExampleClass aBean() {
      ...
      return aObject;
   }
}