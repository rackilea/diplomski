@Bean
public Cache teamConfigsCache() {
    Map<Object, Object> map = ExpiringMap.builder()
        .expiration(15, TimeUnit.MINUTES)
        .build();
    return new ConcurrentMapCache("teamConfigs", map , true);
}