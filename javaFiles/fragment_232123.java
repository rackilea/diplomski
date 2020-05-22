@Configuration
public class Config {

   @Bean
   @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
   public RandomBean randomBean(){
       return new RandomBean();
   }

   @Bean
   public AnotherBean anotherBean(){
       return new AnotherBean(randomBean()); // this line
   }

}