public volatile OtherService s; // an injected service dependency

public void init(Component c) {
  if (s.needsSomeService()) {
    DependencyManager dm = c.getDependencyManager();
    c.add(dm.createServiceDependency()
      .setService(SomeService.class)
      .setInstanceBound(true)
      .setRequired(true));
  }
}