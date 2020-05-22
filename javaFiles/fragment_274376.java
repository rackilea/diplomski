@SpringBootApplication
@EnableSwagger2
@EnableCaching
public class Application extends SpringBootServletInitializer {

  public static void main(final String[] args) throws Exception {
    SpringApplication.run(Application.class, args);
  }

  @Primary
  @Bean
  public RedisCacheManager cacheManager(final RedisConnectionFactory connectionFactory) {
    final RedisCacheWriter redisCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
    final SerializationPair<Object> valueSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
    final RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
    final RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter, cacheConfiguration);
    return redisCacheManager;
  }

  @Bean(name = "pickleCacheManager")
  public RedisCacheManager pickleCacheManager(final RedisConnectionFactory connectionFactory) {
    final RedisCacheWriter redisCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
    final SerializationPair<Object> valueSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
    RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
    cacheConfiguration = cacheConfiguration.entryTtl(Duration.ofSeconds(120));
    final RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter, cacheConfiguration);
    return redisCacheManager;
  }

  @Bean(name = "userCacheManager")
  public RedisCacheManager userCacheManager(final RedisConnectionFactory connectionFactory) {
    final RedisCacheWriter redisCacheWriter = RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
    final SerializationPair<Object> valueSerializationPair = RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer());
    RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();
    cacheConfiguration = cacheConfiguration.entryTtl(Duration.ofSeconds(172800));
    final RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter, cacheConfiguration);
    return redisCacheManager;
  }

}