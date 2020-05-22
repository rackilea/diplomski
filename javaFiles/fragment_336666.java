public static Stream<String> joinGroups(Stream<String> s) {
    Spliterator<String> sp=s.spliterator();
    return StreamSupport.stream(
        new Spliterators.AbstractSpliterator<String>(sp.estimateSize(), 
        sp.characteristics()&Spliterator.ORDERED | Spliterator.NONNULL) {
            private StringBuilder sb = new StringBuilder();
            private String last;

            public boolean tryAdvance(Consumer<? super String> action) {
                if(!sp.tryAdvance(str -> last=str))
                    return false;
                while(last!=null) {
                    sb.append(last);
                    if(!sp.tryAdvance(str -> last=str)) break;
                }
                action.accept(sb.toString());
                sb=new StringBuilder();
                return true;
            }
        }, false);
}