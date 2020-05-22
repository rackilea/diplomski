@Configuration
@ComponentScan("foo.bar.web.controller")
public class MvcConfig {

    @Bean
    public MultipartResolver multipartResolver() {
        return new CommonsMultipartResolver();
    }
}