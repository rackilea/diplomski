int mismatch = len - (alist.size () % len);
    for (int i = 0; i < mismatch; ++i) 
         alist.add (neutral);


public static <T> List<List<T>> splitLists (final List<T> alist, final int len, T neutral) {
    int mismatch = len - (alist.size () % len);
    for (int i = 0; i < mismatch; ++i) alist.add (neutral) ;
    return IntStream.range(0, alist.size()) 
            .filter(i -> i % len == 0) 
            .boxed() 
            .map(i -> alist.subList(i, Math.min(i + len, alist.size()))) 
            .collect(Collectors.toList()); 
}