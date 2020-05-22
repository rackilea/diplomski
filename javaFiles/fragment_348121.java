public class SpringApplicationContext implements ApplicationContextAware {

    private static ApplicationContext CONTEXT;

    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        CONTEXT = ctx;
    }

    public static Object getBean(String name) {
        return CONTEXT.getBean(name);
    }
}