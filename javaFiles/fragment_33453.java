@SpringBootApplication
@PropertySource({
        "file:C:\test.properties"
})
public class Application {
   public static void main(String[] args) {
       SpringApplication.run(Application.class, args);
   }
}