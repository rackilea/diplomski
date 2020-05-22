class UserClass1 {
    @Inject
    UserClass1(@Named("Service1") ServiceClient sc) {
    }
}

class UserClass2 {
    @Inject
    UserClass2(@Named("Service2") ServiceClient sc) {
    }
}

class MyModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ServiceClient.class).annotatedWith(Names.named("Service1")).toInstance(new ServiceClient(new AA()));
        bind(ServiceClient.class).annotatedWith(Names.named("Service2")).toInstance(new ServiceClient(new AB()));
    }
}