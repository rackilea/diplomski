public class YourClass {

    private final CacheController cacheController;

    public YourClass(final CacheController cacheController) {
        this.cacheController = cacheController;
    }

    public void testCacheReadComment2() throws Throwable {
        CacheController cc = this.cacheController;
    }
}