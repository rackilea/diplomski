@Stateless
public class MyEJB implements SomeService {

    @Resource(lookup="java:jboss/infinispan/myCacheCont")  
    private org.infinispan.manager.CacheContainer container;  
    ...
    void doSomethingWithCache() {
       org.infinispan.Cache cache = container.getCache("myCache");
       ...    
       cache.put(...); // Data will be replicated to different nodes, if configured properly
    }
}