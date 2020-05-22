public static <T> void sort(T[] a, Comparator<? super T> c) {
    ...
}

public static void main(String[] args) throws Exception {
    Object[] a = { "1", "2" };
    sort(a, new Comparator() {   <-- warning 
        @Override
        public int compare(Object o1, Object o2) {
            return 0;
        }
    });
}