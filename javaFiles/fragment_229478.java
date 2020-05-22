public class ReloadConfig implements ApplicationContextAware{

private static Logger log = Logger.getLogger(ReloadConfig.class);


private Config config;

@Autowired
ApplicationContext applicationContext;

private ReloadConfig() {
    // Exists only to defeat instantiation.
    config = Config.getInstance();
}

public void reloadIfNotLoaded() throws ConfigurationException{

    CompositeConfiguration configuration = new CompositeConfiguration();

    if(config.getHealthFile() == null){

        log.info("Reloading Adding default properties found in config.properties");
        configuration.addConfiguration(new PropertiesConfiguration("config.properties"));


        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext)getApplicationContext();
        configurableApplicationContext.refresh();
        setApplicationContext(configurableApplicationContext);
    }



}

public void setApplicationContext(ApplicationContext context) throws BeansException {
    applicationContext = context;
}

public ApplicationContext getApplicationContext() {
    return applicationContext;
}