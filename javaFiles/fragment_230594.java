@Module public class UserStoreModule {
  @Provides public abstract UserStore bindUserStore(Dep1 dep1, Dep2 dep2, Dep3 dep3);
}

public class MySqlUserStoreModule extends UserStoreModule {
  @Override public UserStore bindUserStore(Dep1 dep1, Dep2 dep2, Dep3 dep3) {
    return new MySqlUserStore(dep1, dep2);
  }
}

public class RedisUserStoreModule extends UserStoreModule {
  @Override public UserStore bindUserStore(Dep1 dep1, Dep2 dep2, Dep3 dep3) {
    return new RedisUserStore(dep1, dep3);
  }
}

DaggerServerComponent.builder()
    .userStoreModule(
      useRedis
      ? new RedisUserStoreModule()
      : new MySqlUserStoreModule())
    .build();