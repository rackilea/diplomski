public class PropertiesProvider implements ApplicationContextAware{

    private String propertyBeanName;
    private ApplicationContext applicationContext;

    public void setPropertyBeanName(final String propertyBeanName){
        this.propertyBeanName = propertyBeanName;
    }

    @Override
    public void setApplicationContext(final ApplicationContext applicationContext) throws BeansException{
        this.applicationContext = applicationContext;
    }

    public String getProperty(final String propertyName){
        return ((Properties) applicationContext.getBean(propertyBeanName)).getProperty(propertyName);
    }

}