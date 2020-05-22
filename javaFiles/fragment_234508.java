class MyTest {
    private Service service;

    @Override
    public ResourceConfig configure() {
        service = new Service();
        return new ResourceConfig()
            .register(new AbstractBinder() {
                @Override
                public void configure() {
                    bind(service).to(Service.class);
                }
            })
    }
}