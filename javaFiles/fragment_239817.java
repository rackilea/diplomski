@Singleton
public class StartupConfigurationImpl implements StartupConfiguration {
    @Inject
    private Logger log;

    public StartupConfigurationImpl() {
        init();
    }

    public void init(){
        log.info("init");
    }
}