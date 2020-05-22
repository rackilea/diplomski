public static <T extends Vehicle> T buy(Class<T> type, int topSpeed) {
    try {
        return type.getConstructor(Integer.TYPE).newInstance(topSpeed);
    } catch (Exception e) { // or something more specific
        System.err.println("Can't create an instance");
        System.err.println(e);
        return null;
    }
}