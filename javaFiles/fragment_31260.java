@Singleton
public class CacheResource {
    public void put(String key, Object value) { /* snip */ }
    public void get(String key) { /* snip */ }
    /* snip ... */

    @Schedule(hour="*", minute="∗/5")
    public void clearCache() { /* snip */ }
}