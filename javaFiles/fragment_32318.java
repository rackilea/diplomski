public class LoggedInServiceTest extends TestCase {
  private final Provider<StandardDispatchService> serviceProvider;
  private final SimpleScope fakeRequestScope = new SimpleScope();
  private final HttpServletRequest request = new FakeHttpServletRequest();

  protected Injector createInjector() {
    return Guice.createInjector(new FakeRequestScopeModule(),
            new LoggedInServiceModule();
  }

  @Override
  protected void setUp() throws Exception {
    super.setUp();
    Injector injector = createInjector();
    scope.enter();
    serviceProvider = injector.getProvider(StandardDispatchService.class);
  }

  @Override
  protected void tearDown() throws Exception {
    fakeRequestScope.exit()
    super.tearDown();
  }

  public void testNotLoggedIn() {
    fakeRequestScope.enter();
    // fill in values of request
    fakeRequestScope.seed(FakeHttpServletRequest.class, request);

    StandardDispatchService service = serviceProvider.get();
    GetProjectsAction action = new GetProjectsAction();
    try {
        service.execute(action);
        fail();
    } catch (NotLoggedInException expected) {
    }
  }

  private class FakeRequestScopeModule extends AbstractModule() {
    @Override
    protected void configure() {
      bind(RequestScoped.class, fakeRequestScope);
      bind(HttpServletRequest.class)
          .to(FakeHttpServletRequest.class)
          .in(RequestScoped.class)
    }
  }
}