public class MyModule extends AbstractModule{
    @Override
    protected void configure(){
        bind(MyInterfaceA.class).to(MyClassA.class);
        bind(MyInterfaceB.class).to(MyClassB.class);
        bind(MyInterfaceC.class).to(MyClassC.class).in(Singleton.class);
    }
}