try {
    for (java.lang.reflect.Field f : yourObject.getClass().getDeclaredFields()) {
        f.setAccessible(true);
        if (f.get(yourObject) == label1) {
            System.out.println(f.getName());
        }
    }
} catch (Throwable t) {
    throw new RuntimeException(t);
}