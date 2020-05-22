public class CamelFilter implements ApplicationContextAware {
    public boolean isMyBeanNotAvailable() {
        boolean notAvailable = false;
        try {
            notAvailable = this.applicationContext.getBean("myBean") == null;
        } catch (BeanCreationNotAllowedException bcnae) {
            notAvailable = true;
        }
        return notAvailable;
    }
}