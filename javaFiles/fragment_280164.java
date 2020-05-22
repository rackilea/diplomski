public class StorageProxyProvider implements Provider<StorageProxy> {

    public StorageProxy get() {
        StorageProxy storageProxy = new StorageProxy();
        storageProxy.init();
        return storageProxy;
    }

}


public class StorageProxy {

    public void init(){
        System.out.println("init");
    }
    public void proxy(){
        System.out.println("proxy");
    }

}

public class StorageProxyModule extends AbstractModule {
    protected void configure() {
        bind(StorageProxy.class).toProvider(StorageProxyProvider.class).in(Singleton.class);
    }
}


public class Example {
    @Inject
    StorageProxy storageProxy;

    public void doSomethingThatNeedStorageProxy() {
        System.out.println(storageProxy);
        storageProxy.proxy();
    }

}

public class Main {
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new StorageProxyModule());
        Example e = injector.getInstance(Example.class);
        e.doSomethingThatNeedStorageProxy();
        e = injector.getInstance(Example.class);
        e.doSomethingThatNeedStorageProxy();
    }
}