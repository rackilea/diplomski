public static void main(String... args) {
    List<? extends String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
    List<? extends String> cycledTwice = cycle(cycle(list));
}

public static <T> List<T> cycle(List<T> list) {
    list.add(list.remove(0));
    return list;
}