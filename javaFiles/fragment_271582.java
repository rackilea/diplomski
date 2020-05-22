public class SpyBeanInfoProvider implements BeanInfoProvider {
  private final BeanInfoProvider delegate;
  private final Map<Class<?>, BeanInfo> spyMap = new HashMap<>(); 

  public SpyBeanInfoProvider(BeanInfoProvider delegate) {
    this.delegate = delegate;
  }

  @Override
  public BeanInfo getBeanInfo(Object obj) {
    Class<?> klass = obj.getClass();
    if(!spyMap.containsKey(klass)) {
      BeanInfo info = spy(delegate.getBeanInfo(obj));
      spyMap.put(klass, info);
      return info;
    } else {
      return spyMap.get(obj);
    }
  }
}