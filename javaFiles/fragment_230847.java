public static universalClose(Object o) {
    try {
        o.getClass().getMethod("close", null).invoke(o, null);
    } catch (Exception e) {
        throw new IllegalArgumentException("missing close() method");
    }   
}