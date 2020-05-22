public class BeanHelper {
  private final Object bean;
  private final Map<String, Method> getters = new TreeMap<String, Method>();

  public BeanHelper(Object bean) {
    this.bean = bean;
    for (PropertyDescriptor pd : Introspector.getBeanInfo(bean.getClass(),
          Object.class).getPropertyDescriptors()) {
      getters.put(pd.getName(), pd.getReadMethod());
    }
  }

  public Set<String> getProperties() { return getters.keySet(); }

  public Object get(String propertyName) {
    return getters.get(propertyName).invoke(bean);
  }

  public static void main(String[] args) {
    BeanHelper helper = new BeanHelper(new MyBean());
    for (String prop : helper.getProperties()) {
      System.out.format("%s = %s%n", prop, helper.get(prop));
    }
  }

  public static class MyBean {
    private final String foo = "bar";
    private final boolean baz = true;
    public String getFoo() { return foo; }
    public boolean isBaz() { return baz; }
  }
}