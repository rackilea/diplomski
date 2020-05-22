@Bean
public Cache<Foo,Bar> fooBarCache() {
    return new AsyncUpdateCache(refreshTaskMap()); // call the method
}

@Bean
public Map<Foo,Future<Bar>> refreshTaskMap() {
    return new HashMap<Foo,Future<Bar>>();
}