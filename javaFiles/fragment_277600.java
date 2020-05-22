T find(String name, Class<T> clazz) {
    return Stream.of(clazz.getEnumConstants())
        .filter(name::equals)) // note, will NPE if name == null
        .findFirst()
        .get();
}