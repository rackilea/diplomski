interface Predicate<T> {
    boolean test(T object);
}
public static <T> boolean removeIf(List<T> list, Predicate<? super T> p) {
    if(list instanceof RandomAccess) {
        int num=list.size();
        BitSet bs=new BitSet(num);
        for(int index=0; index<num; index++) {
            if(p.test(list.get(index))) bs.set(index);
        }
        if(bs.isEmpty()) {
            return false;
        }
        for(int dst=bs.nextSetBit(0), src=dst;; dst++, src++) {
            src=bs.nextClearBit(src);
            if(src==num) {
              list.subList(dst, src).clear();
              break;
            }
            list.set(dst, list.get(src));
        }
        return true;
    }
    else {
        boolean changed=false;
        for(Iterator<T> it=list.iterator(); it.hasNext(); ) {
            if(p.test(it.next())) {
                it.remove();
                changed=true;
            }
        }
        return changed;
    }
}