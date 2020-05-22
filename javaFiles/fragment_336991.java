public static<E> List<E> porderlist(T<E> a) {
    if (a.isEmpty())
        return new ArrayList<E>();
    else {
        List<E> list = new ArrayList<E>();
        list.add(a.getValue());
        list.addAll(porderlist(a.getLeft()));
        list.addAll(porderlist(a.getRight()));
        return list;
    }    
}