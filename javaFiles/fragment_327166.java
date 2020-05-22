LoadingCache<String, String> userListSource = CacheBuilder.newBuilder()
   .maximumSize(1)
   .expireAfterWrite(10, TimeUnit.MINUTES)
   // ... other configuration builder methods ...
   .build(
       new CacheLoader<String, String>() {
         public Graph load(Key key) {
           return callToYourThirdPartyLibrary();
         }
       });