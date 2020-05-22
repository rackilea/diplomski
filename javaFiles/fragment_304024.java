public Object read(K key) {
    while(true) {
        int version = versionCache.get(key);
        if(version == -1) Thread.sleep(5000);
        else {
            Object returnVal = cache.get(key);
            if(version == versionCache.get(key)) 
                return returnVal;
        }
    }
}