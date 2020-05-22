static LoadingCache<Class<? extends Resource<?>>, ResourceType<? extends Resource<?>>> cache = CacheBuilder.newBuilder().build(
      new CacheLoader<Class<? extends Resource<?>>, ResourceType<? extends Resource<?>>>() {
        @SuppressWarnings({ "rawtypes", "unchecked" })
        @Override public ResourceType<? extends Resource<?>> load(Class<? extends Resource<?>> key) throws Exception {
          return new ResourceType(key);
        }
    });