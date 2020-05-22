T find(String name, Class<T> clazz) {
    for (T elem : clazz.getEnumConstants()) {
        if (elem.name().equals(name)) {
            return elem;
        }
    }
    throw new NoSuchElementException(name); // or whatever
}