public static <X, Y> List<Y> processElements(Iterable<X> source, Function <X, Y> mapper) {
    List<Y> l = new ArrayList<>();
    for (X p : source) 
        l.add(mapper.apply(p));
    return l;
}