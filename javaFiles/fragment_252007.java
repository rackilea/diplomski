public class ClientData {

    private static final AtomicReference<Map<String, Map<Integer, String>>> primaryMapping = new AtomicReference<>();
    private static final CountDownLatch hasBeenInitialized = new CountDownLatch(1);

    public static Map<String, Map<Integer, String>> getPrimaryMapping() {
        try {
            hasBeenInitialized.await();
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        return primaryMapping.get();
    }

    public static void setPrimaryMapping(Map<String, Map<Integer, String>> map) {
        primaryMapping.set(map);
        hasBeenInitialized.countDown();
    }
}