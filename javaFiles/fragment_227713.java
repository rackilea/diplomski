public class CacheController {

    private final CacheController instance = new CacheController();

    public static CacheController getCacheController() {
        return instance;
    }
}