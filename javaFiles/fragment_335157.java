@SpringBootApplication
public class SpringBootApp extends WebMvcConfigurerAdapter {

    @Value("${springBootApp.workOffline:false}")
    private boolean workOffline = false;

    @Value("${springBootApp.setupSchema:false}")
    private boolean setupSchema = false;

    @PostConstruct
    public void initializeDB() {
        if (workOffline) {
            // ...
        } else {
            // ...
        }
        if (setupSchema) {
            // ...
        }
    }
}