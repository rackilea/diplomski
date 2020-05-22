Supplier<EmployeeStatistics> statistics = new Supplier<EmployeeStatistics>() {
  private final Object key = new Object();
  private final LoadingCache<Object, EmployeeStatistics> cache =
      CacheBuilder.newBuilder()
        // configure your builder
        .build(
           new CacheLoader<Object, EmployeeStatistics>() {
             public EmployeeStatistics load(Object key) {
               // same behavior as the Supplier above
             }});

  @Override
  public EmployeeStatistics get() {
    return cache.get(key);
  }};