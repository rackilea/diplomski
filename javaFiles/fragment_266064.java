public static void main(String... args) {
    Throwable t = new Throwable("here");
    System.out.println("Throwable before getStackTrace()");
    shallowDump(t);

    System.out.println("\nThrowable after getStackTrace()");
    t.getStackTrace();
    shallowDump(t);
}

private static void shallowDump(Object pojo) {
    for (Field f : pojo.getClass().getDeclaredFields()) {
        if (Modifier.isStatic(f.getModifiers())) continue;
        f.setAccessible(true);
        Object o;
        try {
            o = f.get(pojo);
            if (o == pojo)
                o = "{self}";
            if (o instanceof Object[])
                o = "Array of "+(o.getClass().getComponentType());
        } catch (Exception e) {
            o = e;
        }
        System.out.println(f.getName() + ": " + o);
    }
}