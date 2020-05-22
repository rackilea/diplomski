public class ComponentLocatorImpl extends ComponentLocator
    implements ApplicationContextAware {
  private ApplicationContext myApplicationContext;

  public void setApplicationContext(ApplicationContext context) {
    myApplicationContext = context;
    myInstance = this;
  }

  @Override
  protected <T> T locateComponent(Class<T> componentClass, String language) {
    String beanName = componentClass.getName() + ":" + language;
    return componentClass.cast(myApplicationContext.getBean(beanName, componentClass));
  }
}