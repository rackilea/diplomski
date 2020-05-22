try {
    final Class<?> clazz = Class.forName("blue.RandomClass");
    final Method method = clazz.getMethod("main", String[].class);

    final Object[] args = new Object[1];
    args[0] = new String[] { "1", "2"};
    method.invoke(null, args);
} catch (final Exception e) {
    e.printStackTrace();
}