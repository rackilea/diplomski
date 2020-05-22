public static <T> T[] merge(T[]... arrays) {    
    List<T> list = new LinkedList<T>();
    for(T[] array : arrays) {
        for(T t : array) {
            list.add(t);
        }
    }
    return (T[])(list.toArray());    
}