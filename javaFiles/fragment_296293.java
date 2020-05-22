public static <T1 extends Comparable<? super T1>> Comparator<TypeType<T1,?>> comparatorFirst() {
    return (tt1, tt2) -> tt1.t1.compareTo(tt2.t1);
}

public static <T2 extends Comparable<? super T2>> Comparator<TypeType<?, T2>> comparatorSecond() {
    return (tt1, tt2) -> tt1.t2.compareTo(tt2.t2);
}