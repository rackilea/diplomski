import org.springframework.security.oauth2.provider.OAuth2Authentication;

@SpringBootApplication
@RestController
public class DemoOAuth2Application {

    @RequestMapping("/user")
    public Authentication user(OAuth2Authentication authentication) {
        LinkedHashMap<String, Object> properties = (LinkedHashMap<String, Object>) authentication.getUserAuthentication().getDetails();
        return properties.get("email");
    }


    public static void main(String[] args) {
        SpringApplication.run(DemoOAuth2Application.class, args);
    }
}