static <T extends Comparable<T>> void sort(T[] a) {
    ...
}

static void main(String[] args) {
   Object[] a = {"1", "2"};
   sort(a); <- compile time error, need explicit cast sort((Comparable[])a);
}