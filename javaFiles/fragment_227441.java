@Component
public class CustomRestTemplate extends RestTemplate {
    @Autowired
    public CustomRestTemplate (List<HttpMessageConverter<?>> messageConverters) {
        super(messageConverters);
    }
}