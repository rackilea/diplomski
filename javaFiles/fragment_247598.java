public class CustomAnnotationBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        Class clazz = bean.getClass();
        do {
            for (Field field : clazz.getDeclaredFields()) {
                if (field.isAnnotationPresent(Localize.class)) {
                    // get message from ResourceBundle and populate the field with it
                }
            }
            clazz = clazz.getSuperclass();
        } while (clazz != null);
        return bean;
    }