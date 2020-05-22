@Bean
public RedisTemplate<String, Object> getRedisTemplate() {
    RedisTemplate<String, Object> template = new RedisTemplate<>();
    Jackson2JsonRedisSerializer jrs = new Jackson2JsonRedisSerializer(String.class);
    template.setKeySerializer(jrs);
    template.setConnectionFactory(jedisConnectionFactory());
    return template;
}