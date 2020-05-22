protected void configure() {
    install(new FactoryModuleBuilder()
     .implement(IA.class, A.class)
     .build(IAFactory.class));

    install(new FactoryModuleBuilder()
     .implement(IB.class, B.class)
     .build(IBFactory.class));
}