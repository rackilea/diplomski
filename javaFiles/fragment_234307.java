@Configuration
public class ApplicationConfiguration {

    @Autowired
    private ResourcePatternResolver resourceResolver;

    @Bean
    public Jaxb2Marshaller oxmMarshaller() throws IOException {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.stackoverflow.xjc");
        marshaller.setSchemas(resourceResolver.getResources("classpath:/META-INF/xsd/*.xsd"));
        return marshaller;
    }
}