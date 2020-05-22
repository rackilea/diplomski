@Configuration
public class SomeConfig {

   @Bean(initMethod = "initMethodName")
   public SomeBeanClass someBeanClass() {
      return new SomeBeanClass();
   }
}