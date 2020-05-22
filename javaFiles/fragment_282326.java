@Configuration
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Value("${myBooleanProperty}")
    private boolean myBooleanProperty;
}