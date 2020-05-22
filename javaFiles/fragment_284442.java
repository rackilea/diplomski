public class ServiceUserGuicified {
  @Inject
  Service service;

  public static void main(String[] args) {
    Injector injector = Guice.createInjector(new FooServiceModule());
    ServiceUserGuicified user = injector.getInstance(ServiceUserGuicified.class);
    user.service.useService();
  }
}

public class FooServiceModule extends AbstractModule {
  @Override
  protected void configure() {
    bind(Service.class).to(FooService.class);
  }
}