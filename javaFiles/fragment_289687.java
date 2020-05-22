public class SubscriptionsRegistry {
    private final Map<Integer, SessionCollection> map = new HashMap<>();

    public synchronized void removeSubscriptions(Integer sessionId) {
        map.values().forEach(...);
    }

    public synchronized void addSubscription(...) {
        ...
    }

    ...
}