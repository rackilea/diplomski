@PostConstruct
private void postConstruct()
        throws NoSuchFieldException, IllegalAccessException {
    final Field sizeField = Club.class.getDeclaredField("size");
    sizeField.setAccessible(true);
    sizeField.set(this, members.size());
}