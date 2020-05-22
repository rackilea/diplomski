@Configuration
class MyConfiguration {
  @Bean
  public static ExtendedBeanFactory extendedBeanFactory() {
    return new ExtendedBeanFactory();
  }
}

class ExtendedBeanFactory implements BeanDefinitionRegistryPostProcessor {
  @Override
  public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
    for (int i = 0; i < 3; i++) {
      GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
      beanDefinition.setBeanClass(Extended1.class);
      ConstructorArgumentValues args = new ConstructorArgumentValues();
      args.addGenericArgumentValue(Integer.toString(i));
      beanDefinition.setConstructorArgumentValues(args);
      registry.registerBeanDefinition("extended_" + i, beanDefinition);
    }
  }

  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
    // noop
  }
}