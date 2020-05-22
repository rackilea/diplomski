// CacheHelper constructor is called to initialize a new CacheHelper
    // => cacheManager attribute is not initialized
    CacheHelper cacheHelper = new CacheHelper();
    // This method will call cacheManager.close().
    // => cacheManager is currently null => NullPointerException
    cacheHelper.clearAllCache();
    // This method will initialize the cacheManager attribute
    // => Too late the Exception already occured
    // => So, need to initialize cacheManager attribute before calling clearAllCache()
    // => the constructor is the best place to do this here.
    cacheHelper.putInCacheFromDb();