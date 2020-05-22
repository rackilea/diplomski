public class SimpleBeanInfoProvider implements BeanInfoProvider {
  public BeanInfo getBeanInfo(Object obj) {
    BeanInfo beanInfo = null;

    try {
      Class cls = obj.getClass();
      beanInfo = Introspector.getBeanInfo(cls);
    } catch (IntrospectionException e) {
      e.printStackTrace();
    }

    return beanInfo;
  }
}