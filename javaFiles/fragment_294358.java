public static <T, U extends Comparable<? super U>> void sortEmpoyeeByCriteria(
            List<T> list,
            Function<? super T, ? extends U> byCriteria) {
        Comparator<? super T> c = Comparator.comparing(byCriteria);
        list.sort(c);
}