@RestController
@RequestMapping("/")
public class ConfigurationController {

    @Bean
    public MultipartConfigElement multipartConfigElement() {
        return new MultipartConfigElement("");
    }

    @Bean
    public MultipartResolver multipartResolver() {
        org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new org.springframework.web.multipart.commons.CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }
    @PostMapping(value = "/config", consumes = "multipart/form-data")
    public ResponseEntity<?> saveEnvironmentConfig(@RequestParam("password") String password, @RequestParam("file") MultipartFile submissions)
            throws AdminAuthenticationException, ConfigurationException {
        return ResponseEntity.ok().body(null);
    }
}