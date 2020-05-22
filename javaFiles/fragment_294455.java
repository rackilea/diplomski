@Configuration
public class HystrixConfig {

    @Autowired
    private CommonsConfigurationFactoryBean props;

    @PostConstruct
    public void init() {
        ConfigurationManager.install(props.getConfiguration());
    }
}