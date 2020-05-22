public class MyStartupClass {

    @Inject
    public MyStartupClass(@NamedCache("system-cache") final CacheAPI cache) {    
        cache.set("test", "test");
    }
}