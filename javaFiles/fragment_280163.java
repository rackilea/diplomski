public class StorageProxyProvider implements Provider<StorageProxy> {
   public StorageProxy get() {
      StorageProxy storageProxy = new StorageProxy();
      storageProxy.init();
      return storageProxy;
   }
}

public class StorageProxyModule extends AbstractModule {
   protected void configure() {
     bind(StorageProxy.class).toProvider(StorageProxyProvider.class).in(Singleton.class);
   }
}