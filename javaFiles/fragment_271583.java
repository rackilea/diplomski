private BeanInfoProvider makeBeanInfoProvider() {
  return new SpyBeanInfoProvider(new IntrospectorBeanInfoProvider());
}

@Test
public void testSub() {
  BeanInfoProvider provider = makeBeanInfoProvider();
  ClientViewer viewer = new ClientViewer(makeBeanInfoProvider());
  viewer.sub(obj);
  BeanInfo spy = provider.getBeanInfo(obj);

  // Now do your test
  verify(spy).getPropertyDescriptors();
  // etc.
}