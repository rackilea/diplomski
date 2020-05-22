public static boolean getBoolean(String name) {
    boolean result = false;
    try {
        result = toBoolean(System.getProperty(name));
    } catch (IllegalArgumentException e) {
    } catch (NullPointerException e) {
    }
    return result;
}

private static boolean toBoolean(String name) {
    return ((name != null) && name.equalsIgnoreCase("true"));
}