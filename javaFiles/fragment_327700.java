AsyncCache<Integer, Integer> cache = Caffeine.newBuilder()
    .maximumSize(10_000)
    .recordStats()
    .buildAsync();

// Perform application work
for (int i = 0; i < 4; i++) {
  cache.get(1, key -> key);
}

// Statistics can be queried and reported on
System.out.println(cache.synchronous().stats());