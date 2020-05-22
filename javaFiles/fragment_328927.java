@Configuration
@PropertySource(name="main", value= "${spring.profiles.active}.main.properties")
public class PropertyTestConfiguration {

    @Autowired
    private Environment env;

    @PostConstruct
    public void initialize() {
        String resource = env.getProperty("spring.profiles.sub") +".main.properties";
        Resource props = new ClassPathResource(resource);
        if (env instanceof ConfigurableEnvironment && props.exists()) {
            MutablePropertySources sources = ((ConfigurableEnvironment) env).getPropertySources();
            sources.addBefore("main", new ResourcePropertySource(props)); 
        }
    }

    @Bean
    public Main_PropertyTest main_PropertyTest(@Value("${main.property}") String property) {
        Main_PropertyTest main_PropertyTest = new Main_PropertyTest(property);
        return main_PropertyTest;
    }
}