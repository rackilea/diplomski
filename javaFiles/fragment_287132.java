...
@Inject public A(@Named("myId") String id, B b, C c)
...
@Inject public B(@Named("myId") String id)
...
@Inject public C(@Named("myId") String id)


public class MyModule extends AbstractGinModule {

  protected void configure() {
    // You can use bindConstant and compute the id in configure()
    String myid = "foo_" + System.currentTimeMillis();
    bindConstant().annotatedWith(Names.named("myId")).to(myId)
  }

  // Or you can use a provider to compute your Id someway 
  @Provides @Named("myId") public String getMyId() {
    return "bar_" + System.currentTimeMillis();
  }      

}