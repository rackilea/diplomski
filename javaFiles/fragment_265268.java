@SpringBootApplication
public class boxApplication extends WebMvcConfigurerAdapter {

@Autowired private TemplateRepository templateRepository;

public static void main(String[] args) {
    SpringApplication.run(boxApplication.class, args);
}

@Override
public void addResourceHandlers(ResourceHandlerRegistry registry) {

    Template template = templateRepository.findById(1);

    for (UploadDirectory local: template.getLocalDirectories()){

        registry.addResourceHandler("/dir" + local.getId() + "/**")
                .addResourceLocations("file://" + local.getDirectory())
                .setCachePeriod(0);
    }
}
}