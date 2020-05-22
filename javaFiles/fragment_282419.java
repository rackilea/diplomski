public class StoreStore {
  @Inject Provider<InMemoryNumberStore> inMemoryNumberStoreProvider;
  // ...
  // You can also inject the Injector to call getInstance with a class literal.

  public StatsStore getStore(DataType dataType, Backend backend) {
    // This can also be a switch or any other sort of lookup, of course.
    if (dataType == NUMBER && backend == IN_MEMORY) {
      return inMemoryNumberStoreProvider.get();
    } // ...
  }
}