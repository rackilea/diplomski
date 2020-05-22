public class CustomClassPathXmlApplicationContext extends FileSystemXmlApplicationContext {

  public CustomClassPathXmlApplicationContext(String... configLocations) throws BeansException {
    super(configLocations, true, null);
  }

  @Override
  protected void initBeanDefinitionReader(XmlBeanDefinitionReader reader) {
    super.initBeanDefinitionReader(reader);
    reader.setValidating(false);
  }
}