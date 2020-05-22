Class<?> c = obj.getClass();
for (Field f : c.getDeclaredFields()) {
    if (f.getType() == int.class) {
        f.setAccessible(true);
        f.set(obj, 10);
    }
}