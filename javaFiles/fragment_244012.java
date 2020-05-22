private static class InstanceHolder {
    private static final YourObject instance = new YourObject();
}

public static YourObject getInstance() {
    return InstanceHolder.instance;
}