public class Test {

  @Inject
  Provider<EntityManager> em;

  @Inject
  UnitOfWork unitOfWork;

  public void test() {
    if(em.get().isOpen())
        System.out.println("EM open");
    unitOfWork.end();  // releases DB connection
  }

  public static void main(String args[]) {
    final Injector injector = createInjector(new DatabaseModule());
    Test app = injector.getInstance(Test.class);
    app.test();
    System.out.println("Done");
    injector.get(PersistService.class).stop();  // releases resources acquired by the underlying EntityManagerFactory
  }
}