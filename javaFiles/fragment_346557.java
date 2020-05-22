public class SecurityFilterChainPostProcessor implements BeanPostProcessor {

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (beanName.equals("myFilterChain")) {
            DefaultSecurityFilterChain fc = (DefaultSecurityFilterChain)bean;
            List<Filter> filters = fc.getFilters();

            // Modify the filter list as you choose here.                
            List<Filter> newFilters = ...

            return new DefaultSecurityFilterChain(fc.getRequestMatcher(), newFilters);
        }

        return bean;
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}