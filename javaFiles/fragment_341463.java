RootBeanDefinition errorChannelDef = new RootBeanDefinition();
    errorChannelDef.setBeanClassName(IntegrationNamespaceUtils.BASE_PACKAGE
            + ".channel.PublishSubscribeChannel");
    BeanDefinitionHolder errorChannelHolder = new BeanDefinitionHolder(errorChannelDef,
            IntegrationContextUtils.ERROR_CHANNEL_BEAN_NAME);
    BeanDefinitionReaderUtils.registerBeanDefinition(errorChannelHolder, registry);