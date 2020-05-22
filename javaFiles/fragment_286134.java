@Configuration
public class MyServiceConfig {
    @Autowired
    private BeanFactory beanFactory;

    @Autowired
    private IMyService myService;

    @Autowired
    private MyInterceptor myInterceptor;

    @Bean
    public IMyService myServiceIntercepted() {
        final Class<?>[] proxyInterfaces = { IMyService.class };
        final Advice[] advices = { this.myInterceptor };
        return createProxy(proxyInterfaces, this.myService, this.beanFactory,
            advices);
    }

    <T> T createProxy(final Class<?>[] proxyInterfaces, final T target,
            final BeanFactory beanFactory) {
        final ProxyFactoryBean proxy =
                createProxyReturnFactoryBean(proxyInterfaces, target, beanFactory);

        return (T) proxy.getObject();
    }

    <T> ProxyFactoryBean createProxyReturnFactoryBean(
            final Class<?>[] proxyInterfaces, final T target, final BeanFactory beanFactory) {
        final ProxyFactoryBean proxy = new ProxyFactoryBean();
        proxy.setBeanFactory(beanFactory);

        if (proxyInterfaces != null) {
            proxy.setProxyInterfaces(proxyInterfaces);
        }

        proxy.setTarget(target);

        return proxy;
    }

    <T> T createProxy(final Class<?>[] proxyInterfaces, final T target,
            final BeanFactory beanFactory, final Advice[] advices) {
        final ProxyFactoryBean proxy =
                createProxyReturnFactoryBean(proxyInterfaces, target, beanFactory);

        for (final Advice advice : advices) {
            proxy.addAdvice(advice);
        }

        return (T) proxy.getObject();
    }
}