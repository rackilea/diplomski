public class MyApplication extends AuthenticatedWebApplication implements
    ApplicationContextAware {

    private ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext applicationContext)
        throws BeansException {
        this.ctx = applicationContext;
    }

    public static MyApplication get() {
        return (MyApplication) WebApplication.get();
    }

    public static Object getSpringBean(String bean) {
        return get().ctx.getBean(bean);
    }

    public static <T> T getSpringBean(Class<T> bean) {
        return get().ctx.getBean(bean);
    }

    ....
}