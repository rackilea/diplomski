public class Library {
    private final Injector injector;

    private Library(Module userModule) {
        // SomeModule and AnotherModule are modules defined in the library
        // and they are not the part of public interface of your library
        this.injector = Guice.createInjector(userModule, new SomeModule(), new AnotherModule());
    }

    public static Library create(Module userModule) {
        return new Library(userModule);
    }

    public MyAPIService myAPIService() {
        return injector.getInstance(MyAPIService.class);
    }
}