/**
 * Update Spring managed properties
 */
public class SpringPropertyUpdater implements ApplicationContextAware {

    private ConfigurableApplicationContext ctx;
    private static final String LOCATION_PROPERTY = "location";
    private static final Log log = LogFactory.getLog(SpringPropertyUpdater.class);

    /**
     * Update managed properties with new value
     */
    public void  updateProperties(String name, Properties props, String comments) {
        ConfigurableListableBeanFactory fb = ctx.getBeanFactory();
        BeanDefinition bf = fb.getBeanDefinition(name);
        String location = (String) bf.getPropertyValues().getPropertyValue(LOCATION_PROPERTY).getValue();
        Resource res = ctx.getResource(location);
        try {
            File file = res.getFile();
            props.store(new FileOutputStream(file), comments);
        } catch (IOException e) {
            log.error(e);
        }
    }

    /**
     * {@inheritDoc}
     */
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.ctx = (ConfigurableApplicationContext) applicationContext;

    }
}