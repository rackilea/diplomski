@Bean
public void ApplicationContextAware pseudoFactory()
{
return new ApplicationContextAware()
  {
    @Override
    public void setApplicationContext( ApplicationContext ac )
    {
      GenericApplicationContext gac = (GenericApplicationContext) ac;

      DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) gac.getBeanFactory();

      for( EnumType enumType : EnumType.values())
      {
        ParameterizedClass pc = new ParameterizedClass(enumType);

        String beanName = enumType.getName() + "ParameterizedClass";

        beanFactory.registerSingleton(beanName, pc);
      }
    }
  }
}