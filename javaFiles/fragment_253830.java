@Configuration
public class AppConfig {
    @Value("${app.constants.name}")
    public void setAppName(String appName) {
        AppConstants.setAppName(appName);
    }
}