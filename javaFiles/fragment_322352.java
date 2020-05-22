@Configuration
public class MyConfiguration {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedOrigins("http://localhost:3000")
                    .allowedMethods("PUT", "DELETE", "GET", "POST") //or allow all as you like
                    .allowedHeaders("header1", "header2", "header3")
                    .exposedHeaders("header1", "header2")
                    .allowCredentials(false).maxAge(3600);
             }
        };
    }
}