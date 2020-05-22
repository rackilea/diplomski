public static <T> void mergeSort(List<T> L, Comparator<T> C){
    int size=L.size();
    if(size<2){
        return;
    }
    int half=size/2;
    List<T> L1=new ArrayList<T>(L.subList(0,half));
    List<T> L2=new ArrayList<T>(L.subList(half,size));

    mergeSort(L1,C);
    mergeSort(L2,C);

    merge(L1,L2,L,C);
    printList(L);
}