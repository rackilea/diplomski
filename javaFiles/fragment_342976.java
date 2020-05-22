public class InjectionVisitorImpl implements InjectionVisitor {
  private static class BindRecord<T> {
    Key<T> key;
    T value;
  }

  private final List<BindRecord<?>> bindings = new ArrayList<BindRecord<?>>();
  private final Injector injector;

  public InjectionVisitorImpl(Injector injector) {
    this.injector = injector;
  }

  public void needsInjection(Object obj) {
    injector.injectMemebers(obj);
  }

  public <T> void makeInjectable(Key<T> key, T instance) {
    BindRecord<T> record = new BindRecord<T>();
    record.key = key;
    record.value = instance;
    bindings.add(record);
  }

  public Injector createFullInjector(final Module otherModules...) {
    return injector.createChildInjector(new AbstractModule() {
      protected void configure() {
        for (Module m : otherModules) { install(m); }
        for (BindRecord<?> record : bindings) { handleBinding(record); }
      }
      private <T> handleBinding(BindRecord<T> record) {
        bind(record.key).toInstance(record.value);
      }
    });
  }
}