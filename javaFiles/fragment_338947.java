@Configuration
public class AppConfiguration{
   @Bean 
   @Scope("prototype")
   public Triangle triangle(){
      return new Triangle();
   }
}