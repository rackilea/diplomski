@Module public interface MySqlModule {
   @Binds UserStore bindUserStore(MySqlUserStore mySqlUserStore);
}

@Module public interface RedisModule {
   @Binds UserStore bindUserStore(RedisUserStore redisUserStore);
}

@Component(modules = {MySqlModule.class, OtherModule.class})
public interface MySqlServerComponent { Server server(); }

@Component(modules = {RedisModule.class, OtherModule.class})
public interface RedisServerComponent { Server server(); }