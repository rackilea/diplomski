public static <T> List<T> list(T... xs) {
    final List<T> lst = new ArrayList<T>();
    for (final T x : xs) {
        lst.add(x);
    }
    Object[] arr = xs; //arrays are covariant, we can do this
    arr[0] = Arrays.asList(4); //<--------heap pollution
    return lst;
}
public static void main(String[] args) {
    List[] arr = { Arrays.asList("one"), Arrays.asList("two"), Arrays.asList("three") };
    List<List<String>> l = list(arr);
    for (List list : arr) {
        System.out.println(list.get(0));
    }
}