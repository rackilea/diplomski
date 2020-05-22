Foo getFoo(String name) {
    return firstOrNull(getFoos(name));
}
List<Foo> getFoos(String ... names) {
    return getFoos(Arrays.asList(names));
}
List<Foo> getFoos(List<String> names) {
    ....
}