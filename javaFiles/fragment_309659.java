public static <T extends Comparable<? super T>> void clean(List<List<List<T>>> list) {
    List<List<List<T>>> removals = new ArrayList<>();
    for(List<List<T>> item : list) {
        if(!check(item))
            removals.add(item);
    }
    for(List<List<T>> item : removals) {
        list.remove(item);
    }
}