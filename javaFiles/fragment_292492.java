public class ChildApplicationContextFactoryBean implements FactoryBean, ApplicationContextAware {

    protected String[] configLocations;

    protected ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object getObject() throws Exception {
        return new ClassPathXmlApplicationContext(configLocations, applicationContext);
    }

    @Override
    public Class getObjectType() {
        return ClassPathXmlApplicationContext.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

    public void setConfigLocations(String[] configLocations) {
        this.configLocations = configLocations;
    }

}