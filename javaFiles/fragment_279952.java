Object cacheElement = cache.get(cacheKey);
    if (cacheElement != null) {            
        LOG.debug("Returning element in cache: {}", cacheElement);            
    } else {
        synchronized(<something>) {
               // double-check locking, works in Java SE 5 and newer
           if ((cacheElement = cache.get(cacheKey)) == null) {
               // a second check to make sure a previous thread didn't load it
               cacheElement = getResultAndCache(methodInvocation, cacheKey);
           } else {
               LOG.debug("Returning element in cache: {}", cacheElement);            
           }
        }
    }
    return cacheElement;