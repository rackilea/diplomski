public class AnnotatedBeanTargetSource implements TargetSource, BeanFactoryAware {

    private ConfigurableListableBeanFactory beanFactory;
    private Class<? extends Annotation> annotationType;
    private Class<?> implementedIterface;
    private Map<String, Object> beans;

    @Override
    public Class<?> getTargetClass() {
        return this.implementedIterface;
    }

    @Override
    public boolean isStatic() {
        return false;
    }

    @Override
    public Object getTarget() throws Exception {
        if (this.beans == null) {
            this.beans = lookupTargets();
        }

        return this.beans.get(MyValueHolder.get());
    }

    protected Map<String, Object> lookupTargets() { 
        Map<String, Object> resolvedBeans = new HashMap<String, Object>();
        String[] candidates = beanFactory.getBeanNamesForAnnotation(annotationType);
        for (String beanName : candidates) {
            Class<?> type = beanFactory.getType(beanName);

            if (this.implementedIterface.isAssignableFrom(type)) {
                Annotation ann = AnnotationUtils.getAnnotation(type, annotationType);
                resolvedBeans.put((String) AnnotationUtils.getValue(ann), beanFactory.getBean(beanName));
            }
        }

        return resolvedBeans;
    }

    @Override
    public void releaseTarget(Object target) throws Exception {
        // nothing to do
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = (ConfigurableListableBeanFactory) beanFactory;

    }

    public Class<? extends Annotation> getAnnotationType() {
        return annotationType;
    }

    public void setAnnotationType(Class<? extends Annotation> annotationType) {
        this.annotationType = annotationType;
    }

    public Class<?> getImplementedIterface() {
        return implementedIterface;
    }

    public void setImplementedIterface(Class<?> implementedIterface) {
        this.implementedIterface = implementedIterface;
    }
}