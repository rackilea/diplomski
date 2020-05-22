public static Stream<String> joinGroups(Stream<String> s) {
    Spliterator<String> sp=s.spliterator();
    return StreamSupport.stream(
        new Spliterators.AbstractSpliterator<String>(sp.estimateSize(), 
        sp.characteristics()&Spliterator.ORDERED | Spliterator.NONNULL) {
            private String next;

            public boolean tryAdvance(Consumer<? super String> action) {
                if(!sp.tryAdvance(str -> next=str))
                    return false;
                String string=next;
                if(string==null) string="";
                else if(sp.tryAdvance(str -> next=str) && next!=null) {
                    StringBuilder sb=new StringBuilder().append(string);
                    do sb.append(next);while(sp.tryAdvance(str -> next=str) && next!=null);
                    string=sb.toString();
                }
                action.accept(string);
                return true;
            }
        }, false);
}