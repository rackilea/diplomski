public class AutowireCandidateResolverConfigurer implements BeanFactoryPostProcessor {

    private AutowireCandidateResolver autowireCandidateResolver;

    public void postProcessBeanFactory(
            ConfigurableListableBeanFactory beanFactory) throws BeansException {
        DefaultListableBeanFactory  bf = (DefaultListableBeanFactory) beanFactory;
        bf.setAutowireCandidateResolver(autowireCandidateResolver);


    }

    public AutowireCandidateResolver getAutowireCandidateResolver() {
        return autowireCandidateResolver;
    }

    public void setAutowireCandidateResolver(

            AutowireCandidateResolver autowireCandidateResolver) {
        this.autowireCandidateResolver = autowireCandidateResolver;
    }

}

<bean id="autowireCandidateResolverConfigurer" class="AutowireCandidateResolverConfigurer">
        <property name="autowireCandidateResolver">
            <bean class="ProxyAutowiredCandidateResolver" />
        </property>
</bean>