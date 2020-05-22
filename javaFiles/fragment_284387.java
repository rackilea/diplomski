@Configuration
public class Config {
    @Bean
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS, value = "prototype")
    public UserProfile attachDocController() throws IOException {
        return new UserProfile();
    }
}