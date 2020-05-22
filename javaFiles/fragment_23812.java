@Bean
public static BeanFactoryPostProcessor beanFactoryPostProcessor() {
    return new BeanFactoryPostProcessor() {

        @Override
        public void postProcessBeanFactory(
                ConfigurableListableBeanFactory beanFactory) throws BeansException {
            BeanDefinition bean = beanFactory.getBeanDefinition(
                    DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);

            bean.getPropertyValues().add("loadOnStartup", 1);
        }
    };
}