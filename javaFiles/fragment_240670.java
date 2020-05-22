Injector injector = Guice.createInjector(b -> {
    b.bind(InterfaceA.class).annotatedWith(Names.named("a")).to(A.class);
    b.bind(InterfaceA.class).annotatedWith(Names.named("a1")).to(B.class);
    b.bind(Invoke.class);
});


public class Invoke {
    private final Injector injector;

    @Inject
    Invoke(Injector injector) {
        this.injector = injector;
    }

    public void invoke() {
        this.foo(
            injector.getInstance(Key.get(InterfaceA.class, Names.named("a"))),
            injector.getInstance(Key.get(InterfaceA.class, Names.named("a1")))
        );
    }

    void foo(InterfaceA a, InterfaceA a1){
        ...
    }
}