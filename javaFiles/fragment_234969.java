@Component
@ConfigurationProperties(locations = "myConfiguration")// myConfiguration is customized placeholder
public class MyProperties{
   String username;
   String password;
   //Getters, Setters…
}