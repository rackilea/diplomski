public class GuiceCamelTestModule extends CamelModuleWithMatchingRoutes {

    ...

    @Provides
    @JndiBind("redisTemplateBean")
    Object provideRedisTemplateBean() {
        JedisConnectionFactory redisConnectionFactory = new  JedisConnectionFactory();
        redisConnectionFactory.afterPropertiesSet();

        RedisTemplate<?, ?> template = new RedisTemplate();
        template.setConnectionFactory(redisConnectionFactory);
        template.setDefaultSerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }
}