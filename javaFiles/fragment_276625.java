public static void main(String[] args) {
    List<Integer> a = Arrays.asList(1, 2);
    List<Integer> b = Arrays.asList(3, 4);
    List<List<Integer>> collect = b.stream().map(e -> Stream.concat(a.stream(), Stream.of(e)).collect(Collectors.toList()))
            .collect(Collectors.toList());
    System.out.println(collect);
}