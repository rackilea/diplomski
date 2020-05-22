@Configuration
@EnableWebMvc
public class WebConfiguration implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/blockchain/**")
                .allowedOrigins("http://frontend:3000")
                .allowedHeaders("*")
                .allowedMethods("*")
                .exposedHeaders("Access-Control-Allow-Headers",
                        "Access-Control-Allow-Origin, Origin, Accept, X-Requested-With, " +
                                "Content-Type, Access-Control-Request-Method, Access-Control-Request-Headers")
                .maxAge(3600);
    }
}