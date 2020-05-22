Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                service = mock(Service.class);
                binder.bind(Service.class).
                    toInstance(service);
}