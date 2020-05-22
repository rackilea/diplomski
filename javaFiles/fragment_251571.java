@MyKeyGenerator("myKeyGenerator1")
@Cacheable(cacheNames="cacheName1")
Foo method1(...) { ... }

@MyKeyGenerator("myKeyGenerator2")
@Cacheable(cacheNames="cacheName2")
Bar method2(...) { ... }