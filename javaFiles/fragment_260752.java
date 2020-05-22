// chops a list into non-view sublists of length L
static <T> List<List<T>> chopped(List<T> list, final int L) {
    List<List<T>> parts = new ArrayList<List<T>>();
    final int N = list.size();
    for (int i = 0; i < N; i += L) {
        parts.add(new ArrayList<T>(
            list.subList(i, Math.min(N, i + L)))
        );
    }
    return parts;
}


List<Integer> numbers = Collections.unmodifiableList(
    Arrays.asList(5,3,1,2,9,5,0,7)
);
List<List<Integer>> parts = chopped(numbers, 3);
System.out.println(parts); // prints "[[5, 3, 1], [2, 9, 5], [0, 7]]"
parts.get(0).add(-1);
System.out.println(parts); // prints "[[5, 3, 1, -1], [2, 9, 5], [0, 7]]"
System.out.println(numbers); // prints "[5, 3, 1, 2, 9, 5, 0, 7]" (unmodified!)