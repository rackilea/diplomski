ResolvableType resolvableType = ResolvableType.forClassWithGenerics(AsyncClient.class, serviceInterface);

RootBeanDefinition rootBeanDefinition = new RootBeanDefinition();
rootBeanDefinition.setTargetType(resolvableType);
rootBeanDefinition.setBeanClass(CarFactoryBean.class);
rootBeanDefinition.getPropertyValues().add("type", serviceInterface);
rootBeanDefinition.setDescription("desc");