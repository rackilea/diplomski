@Bean
    public RedisCacheConfiguration myCacheConfiguration()
    {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ZERO)
                .disableCachingNullValues()
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new CustomSerializer(Map.class)));
    }