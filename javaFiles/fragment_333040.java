@Bean
public RedisTemplate<byte[], byte[]> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<byte[], byte[]> template = new RedisTemplate<>();
    template.setConnectionFactory(redisConnectionFactory);
    // set this false will keep all Serializer null
    template.setEnableDefaultSerializer(false);
    return template;
}