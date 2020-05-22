public static <T extends Comparable<T>> T max(List<? extends T> list, int begin, int end) {
    ...
}

public static void main(String[] args) {
    List<Child> list = new ArrayList<Child>();
    max(list, 0, 2);  // Error with current method. Child does not implement Comparable<Child>
}