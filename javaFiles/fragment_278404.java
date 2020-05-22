public class MyFactory {
    private static final Model THE_INSTANCE = ModelFactory.createDefaultModel();
    static {
        // Use this static initializer for any other model setup stuff.
    }
    public static Model getModel() { return THE_INSTANCE; }
}