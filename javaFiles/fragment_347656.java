public static <T extends Foo> List<T> getFromList(List<Foo> list, Class<T> type) {
    return list.stream()
               .filter(type::isInstance)
               .map(type::cast)
               .collect(Collectors.toList());
}