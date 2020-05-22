public class IdProvider {
    private static IdProvider instance = null;

    public IdProvider getInstance() {
        if (instance == null) {
            instance = new IdProvider();
        }

        return instance;
    }

    private int nextID = 0;

    public int getUniqueId() {
        if (nextId < 0) {
            throw new IllegalStateException("Out of IDs!");
        }

        int uniqueId = nextId;
        nextId++;

        return uniqueId;
    }
}