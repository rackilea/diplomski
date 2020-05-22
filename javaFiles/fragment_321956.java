@SpringBootApplication
public class TmpApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(TmpApplication.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/tmp/**").addResourceLocations("file:///./myfolder/")
                .setCachePeriod(0);
    }
}