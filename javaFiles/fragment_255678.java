public class ProxyInjectingBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        if (AopUtils.isAopProxy((bean))){
            try {
                Object target = ((Advised)bean).getTargetSource().getTarget();
                if (target instanceof ProxyAware){
                    ((ProxyAware) target).setProxy(bean);
                }
            } catch (Exception e) {
                // ignore
            }
        }
        return bean;
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}