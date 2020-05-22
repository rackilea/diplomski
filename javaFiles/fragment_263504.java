private static Class<?>[] getInterfaces(Class<?> c) {
    List<Class<?>> result = new ArrayList<Class<?>>();
    if (c.isInterface()) {
        result.add(c);
    } else {
        do {
            addInterfaces(c, result);
            c = c.getSuperclass();
        } while (c != null);
    }
    for (int i = 0; i < result.size(); ++i) {
        addInterfaces(result.get(i), result);
    }
    return result.toArray(new Class<?>[result.size()]);
}

private static void addInterfaces(Class<?> c, List<Class<?>> list) {
    for (Class<?> intf: c.getInterfaces()) {
        if (!list.contains(intf)) {
            list.add(intf);
        }
    }
}