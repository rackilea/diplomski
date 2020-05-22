public static <T extends Comparable<? super T>> boolean notEqual(List<T> a, List<T> b) {
    for(int i = 0; i < Math.min(a.size(), b.size()); i++) {
        T ao = a.get(i);
        T bo = b.get(i);

        if(ao.compareTo(bo) != 0)
            return true;
    }

    return false;
}