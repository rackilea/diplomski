public static void main(String[] args) throws Exception {
    final Set<String> first = new HashSet<>(Arrays.asList("hello", "to", "you"));
    final Set<String> second = new HashSet<>(Arrays.asList("hello", "to", "me"));

    System.out.println(intersection(first, second));
    System.out.println(union(first, second));

}

public static Set<String> intersection(final Set<String> first, final Set<String> second) {
    final Set<String> copy = new HashSet<>(first);
    copy.retainAll(second);
    return copy;
}

public static Set<String> union(final Set<String> first, final Set<String> second) {
    final Set<String> copy = new HashSet<>(first);
    copy.addAll(second);
    return copy;
}