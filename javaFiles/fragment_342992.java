@Configuration
public class Thymeleaf {
    @Bean
    public MessageSource messageSource() throws Exception {
        ReloadableResourceBundleMessageSource res = new ReloadableResourceBundleMessageSource();
        res.setBasename("file:src/main/resources/messages");
        return res;
    }
}