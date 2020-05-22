@Component
public class DiscoveringPostProcessor implements BeanPostProcessor, ApplicationContextAware {

    ApplicationContext applicationContext;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // TODO Auto-generated method stub
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof CustomLoggingFilter){
            Map<String, TurboFilter> filterBeans = applicationContext.getBeansOfType(TurboFilter.class);
            for (TurboFilter filter : filterBeans.values()) {
                LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
                loggerContext.addTurboFilter(filter);
            }
        }
        return bean;

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

}