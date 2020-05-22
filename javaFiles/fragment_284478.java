@Autowired
    private AbstractBeanFactory beanFactory;

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof AbstractMessageChannel) {
            try {
                RootBeanDefinition beanDefinition = (RootBeanDefinition) beanFactory.getMergedBeanDefinition(beanName);
                Method method = beanDefinition.getResolvedFactoryMethod();

                if (method != null) {
                    if (AnnotationUtils.findAnnotation(method, Input.class) != null) {
                        ((AbstractMessageChannel)bean).addInterceptor(/*Your input ChannelInterceptor*/);
                    } else if (AnnotationUtils.findAnnotation(method, Output.class) != null) {
                        ((AbstractMessageChannel)bean).addInterceptor(/*Your output ChannelInterceptor*/);
                    }
                }
            } catch (Exception e) {
                // exception can be thrown by the bean factory
            }
        }

        return bean;
    }