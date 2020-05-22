public final class Resource {

    private static Resource instance;

    private Resource() {

    }

    public static synchronized Resource getInstance() {
        if (instance == null) {
            instance = new Resource();
        }
        return instance;
    }
}