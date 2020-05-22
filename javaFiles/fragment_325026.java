public static int getIdByName(final String name) {
    try {
        final Field field = R.id.class.getDeclaredField(name);

        field.setAccessible(true);
        return field.getInt(null);
    } catch (Exception ignore) {
        return -1;
    }
}