public static <T> void merge(List<T> L1, List<T> L2,List<T> L, Comparator<T> C){
        int i=0;
        int j=0;
        int k=0;
        while(i < L1.size() && j < L2.size()) {
            if(C.compare(L1.get(i), L2.get(j)) < 0) {
                L.set(k++, L1.get(i++));
            }else {
                L.set(k++, L2.get(j++));
            }   
        }
        while(i < L1.size()) {
            L.set(k++, L1.get(i++));
        }
        while(j < L2.size()) {
            L.set(k++, L2.get(j++));
        }
    }