@Configuration
public class Spring {

    @Value("classpath:choice-test.html")
    private Resource sampleHtml;

    @Bean
    public String sampleHtmlData() {
        try(InputStream is = sampleHtml.getInputStream()) {
            return IOUtils.toString(is);
        }
    }
}