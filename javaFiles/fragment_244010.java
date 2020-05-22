private static YourObject instance;

public static synchronized YourObject getInstance() {
    if (instance == null) {
        instance = new YourObject();
    }
    return instance;
}