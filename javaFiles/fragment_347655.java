public static <T extends Foo, S extends T> List<S> getFromList(List<T> list, Class<S> type) {
    return list.stream()
               .filter(type::isInstance)
               .map(type::cast)
               .collect(Collectors.toList());
}