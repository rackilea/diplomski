public static String getConstantValue(String name) {
    try {
        return (String) Constants.class.getDeclaredField(name).get(null);
    } catch (Exception e) {
        throw new IllegalArgumentException("Constant value not found: " + name, e);
    }
}