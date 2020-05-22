public class MocksCollector {
    private final List<Object> createdMocks;

    public MocksCollector() {
        createdMocks = new LinkedList<Object>();
        final MockingProgress progress = new ThreadSafeMockingProgress();
        progress.setListener(new CollectCreatedMocks(createdMocks));
    }

    public Object[] getMocks() {
        return createdMocks.toArray();
    }
}