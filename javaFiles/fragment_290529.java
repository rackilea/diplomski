<T> T pick(T a, T b) {
    return null;
}

<C, A extends C, B extends C> C test(A a, B b) {
    return pick(a, b); // inferred type: Object
}

void tryIt(List<? super Integer> list1, List<? super Integer> list2) {
    test(list1,  list2);
}