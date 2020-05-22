@Configuration
public class Calling {

   private @Autowired List<ExampleClass> exampleBeans;

   @Bean
   public Foo anotherBean() {
      return aObject;
   }
}