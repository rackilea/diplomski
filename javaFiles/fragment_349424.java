public static <T> void test() {
    ListList<T> var = new ArrayListList<>();
    List<? extends List<T>> work = var; // Compiles
    List<List<T>> notWork = var; // Compiles
    List<List<T>> explicit = (List<List<T>>) var; // Compiles
    List<List<T>> raw = (ListList) var; // Compiles with warning
    List<List<T>> copy = new ArrayList<>(); // Compiles
    copy.addAll(var); // Compiles
}