@Service
public class ServiceCacheManagerExample {

    @Autowired 
    private CacheManager cacheManager;     

    public void clearAllCaches(){
        for(String name:cacheManager.getCacheNames()){
            cacheManager.getCache(name).clear();    
        }
    }
}