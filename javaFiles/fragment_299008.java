@Configuration
public class CommonConfig {
...
        @Bean
        public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
            PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
            ppc.setLocations(new FileSystemResource("/etc/webapp_properties/security-token.properties"),
                    new ClassPathResource("config/WebApp.properties"),
                    new ClassPathResource("config/" + System.getenv("CURRENTENV") + "/WebApp.properties"));
            return ppc;
        }
...
}