@SuppressWarnings("unchecked")
public static <T> T getCurrentInstance(Class<T> beanClass) {
    BeanManager beanManager = CDI.current().getBeanManager();
    Bean<T> bean = (Bean<T>) beanManager.resolve(beanManager.getBeans(beanClass));
    return (T) beanManager.getReference(bean, bean.getBeanClass(), beanManager.createCreationalContext(bean));
}