@Configuration
public class CustomWebMvcAutoConfig implements WebMvcConfigurer {

    String myExternalFilePath = "file:C:/TMP/webData/images/"; // end your path with a /

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations(myExternalFilePath);
    }
}