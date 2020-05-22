@Configuration
@PropertySource("file:config.properties")
public class ApplicationConfiguration {

    @Autowired
    private Environment env;

    public void foo() {
        env.getProperty("gMapReportUrl");
    }

}