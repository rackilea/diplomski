class RetrieverDependencyInjector implements IndirectActorProducer {
    final Injector injector;

    public RetrieverDependencyInjector(Injector injector) {
        this.injector = injector;
    }

    @Override
    public Class<? extends Actor> actorClass() {
        return Retriever.class;
    }

    @Override
    public Retriever produce() {
        return injector.getInstance(Retriever.class);
    }
}