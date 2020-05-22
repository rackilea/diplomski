@Component
public class SimpleCache {

    @Cacheable("map")
    public Map<String, String> getMap() {
        simulateSlowService();
        Map<String, String> result = new HashMap<>();
        result.put("foo", "bar");
        result.put("bar", "foo");
        return result;
    }

    // Don't do this at home
    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

}