Set<Foo> set = new HashSet<>(); // or LinkedHashSet if you need a similar order than the array
for(Foo[] inner : array) {
    for(Foo item : inner) {
        set.add(item);
    }
}