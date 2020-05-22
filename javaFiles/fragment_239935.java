@Component
public class SpringContextUtil implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    // include getter/setter for applicationContext as well

    public <T> T getBean(String name) {
        return (T) applicationContext.getBean(name);
    }
}