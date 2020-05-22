public class MyStatefulBean implements InitializingBean, ApplicationContextAware, BeanNameAware {

    private String myName;

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void setBeanName(String s) {
        this.myName = s;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        if(this.context.isSingleton(this.myName))
            throw new RuntimeException("Bean CANNOT be singleton");
    }
}