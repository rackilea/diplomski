abstract class CModule extends PrivateModule {
    private final Class<? extends Annotation> annotation;

    CModule(Class<? extends Annotation> annotation) {
        this.annotation = annotation;
    }

    @Override protected void configure() {
        bind(C.class).annotatedWith(annotation).to(C.class);
        expose(C.class).annotatedWith(annotation);

        bindConfig();
    }

    abstract void bindConfig();
}

public static void main(String[] args) {
        Injector injector = Guice.createInjector(
                new CModule(Propsal1.class) {
                    @Override void bindConfig() {
                        bind(ConcreteImplConfig.class).toInstance(new ConcreteImplConfig());
                    }
                },
                new CModule(Propsal2.class) {
                    @Override void bindConfig() {
                        bind(ConcreteImplConfig.class).toInstance(new ConcreteImplConfig());
                    }
                },
                new CModule(Propsal2.class) {
                    @Override void bindConfig() {
                        bind(ConcreteImplConfig.class).toInstance(new ConcreteImplConfig());
                    }
                }
                );
    }