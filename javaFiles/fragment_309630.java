public static <T extends A> void foo(Collection<T> bar) {
    List<T> listA = new ArrayList<>();

    for(T a : bar) {
        //a and anotherA are both of the same subtype of A
        T anotherA = getAnotherA(a);
        listA.add(anotherA);
    }

    bar.clear();
    bar.addAll(listA);
}