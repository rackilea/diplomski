public class UpdatableMultipartConfigElement extends MultipartConfigElement {

    private volatile long maxFileSize = -1;

    public UpdatableMultipartConfigElement(String location, long maxFileSize, long maxRequestSize, int fileSizeThreshold) {
        super(location, maxFileSize, maxRequestSize, fileSizeThreshold);
    }

    @Override
    public long getMaxFileSize() {
        return maxFileSize == -1 ? super.getMaxFileSize() : maxFileSize;
    }

    public void setMaxFileSize(long maxFileSize) {
        this.maxFileSize = maxFileSize;
    }
}

@Configuration
@EnableConfigurationProperties(MultipartProperties.class)
public class MultipartConfiguration {

    private final MultipartProperties multipartProperties;

    public MultipartConfiguration(MultipartProperties multipartProperties) {
        this.multipartProperties = multipartProperties;
    }

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigElement multipartConfigElement = multipartProperties.createMultipartConfig();
        return new UpdatableMultipartConfigElement(multipartConfigElement.getLocation(), multipartConfigElement.getMaxFileSize(),
                multipartConfigElement.getMaxRequestSize(), multipartConfigElement.getFileSizeThreshold());
    }
}

@RestController
public class ConfigurationController {

    @Autowired
    private UpdatableMultipartConfigElement updatableMultipartConfigElement;

    @RequestMapping("/configuration")
    public void configuration(@RequestParam("maxFileSize") long maxFileSize) {
        updatableMultipartConfigElement.setMaxFileSize(maxFileSize);
    }

}