@Provides @Singleton
public MyService myService() {
  return new MyService();
}

@Provides
public Set<Service> services(MyService myService) {
  return ImmutableSet.<Service>of(myService);
}