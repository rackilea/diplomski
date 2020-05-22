@ComponentScan(basePackageClasses={AppConfig.class, SlemberApplication.class})
@SpringBootApplication
public class SlemberApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        super.configure(builder);
    }
    public static void main(String[] args) {
        new SpringApplicationBuilder().build().run(SlemberApplication.class, args);
    }
}