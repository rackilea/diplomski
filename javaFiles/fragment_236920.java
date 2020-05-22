@PostConstruct
  public void init()
  {
    userLdapGroupsCache = 
    CacheBuilder.newBuilder()
     .maximumSize(cacheMaxSize)
     .expireAfterWrite(cacheExpireTime, TimeUnit.MINUTES)
     ...
  }