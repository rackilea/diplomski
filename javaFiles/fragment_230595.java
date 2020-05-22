@Module public class UserStoreModule {
  private final StoreType storeType;
  UserStoreModule(StoreType storeType) { this.storeType = storeType; }

  @Provides UserStore provideUserStore(
      Provider<MySqlUserStore> mySqlProvider,
      Provider<RedisUserStore> redisProvider,
      Provider<FakeUserStore> fakeProvider) {
    switch(storeType) {
      case MYSQL: return mySqlProvider.get();
      case REDIS: return redisProvider.get();
      case FAKE: return fakeProvider.get();  // you probably don't want this in prod
    }
    throw new AssertionError("Unknown store type requested");
  }
}