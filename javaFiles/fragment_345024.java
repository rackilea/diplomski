@Bean
@Profile("profile1")
public CacheManager hazelcastCacheManger() {
    ...
}

@Bean
@Profile("profile2")
public CacheManager infinispanCacheManger() {
    ...
}