static class SecurityFilterChainPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("springSecurityFilterChain".equals(beanName)) {
            FilterChainProxy fcp = (FilterChainProxy) bean;
            for (SecurityFilterChain fc : fcp.getFilterChains()) {
                fc.getFilters().add(0, new FiveHundredFilter());
            }
        }
        return bean;
    }
}