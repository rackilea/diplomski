public Foo(String n, List<Integer> ids) {
    this.name = n;
    this.ids.addAll(ids);
}

public static Foo merge(Foo src, Foo dest) {
    List<Integer> merged = new ArrayList<>();
    merged.addAll(src.ids);
    merged.addAll(dest.ids);
    return new Foo(src.name, merged);
}