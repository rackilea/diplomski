public class UserPassAuthFilterBeanPostProcessor implements BeanPostProcessor {

    private String usernameParameter;
    private String passwordParameter;

    @Override
    public final Object postProcessAfterInitialization(final Object bean, final String beanName) {
        return bean;
    }

    @Override
    public final Object postProcessBeforeInitialization(final Object bean, final String beanName) {
        if (bean instanceof UsernamePasswordAuthenticationFilter) {
            final UsernamePasswordAuthenticationFilter filter = (UsernamePasswordAuthenticationFilter) bean; 
            filter.setUsernameParameter(getUsernameParameter());
            filter.setPasswordParameter(getPasswordParameter());
        }

        return bean;
    }
    //...
}