public static void main(String[] args) {
    Stream<List<Integer>> st = Stream.of(List.of());
    System.out.println(size(st));

    st = Stream.empty();
    System.out.println(size(st));

    st = Stream.of(List.of(), List.of(1), List.of(1, 2), List.of(1, 2, 3));
    System.out.println(size(st));
}