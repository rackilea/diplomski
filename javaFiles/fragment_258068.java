BeanDefinitionRegistry registry = ((BeanDefinitionRegistry )factory);

  GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
  beanDefinition.setBeanClass(MyBeanClass.class);
  beanDefinition.setLazyInit(false);
  beanDefinition.setAbstract(false);
  beanDefinition.setAutowireCandidate(true);
  beanDefinition.setScope("session");

  registry.registerBeanDefinition("dynamicBean",beanDefinition);