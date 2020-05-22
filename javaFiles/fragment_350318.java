@Configuration
@ComponentScan
public class UserConfig {

  //If their is default constructor in CreateUser then
  @Bean
  public CreateUser createUserBeanCreate(){
    return new CreateUser();
  }
}