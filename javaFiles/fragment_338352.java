@Bean
public ServiceLocatorFactoryBean myFactoryServiceLocatorFactoryBean()
{
    ServiceLocatorFactoryBean bean = new ServiceLocatorFactoryBean();
    bean.setServiceLocatorInterface(MyServiceFactory.class);
    return bean;
}

@Bean
public MyServiceFactory myServiceFactory()
{
    return (MyServiceFactory) myFactoryServiceLocatorFactoryBean().getObject();
}