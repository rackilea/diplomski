Cache<CustomDate, List<Stat>> cache = CacheBuilder.newBuilder()
        .expireAfterWrite(30, TimeUnit.MINUTES)
        .build();

cache.put(new CustomDate(), stats);
List<Stat> statsForTime = cache.get(new CustomDate(/*appropriate initialization*/));