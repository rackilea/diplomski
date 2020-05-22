public static <T extends Comparable<T>> void serialSort(List<T> list){
    if (list == null || list.size() <= 1) {
        return;
    }
    T pivot = list.get(list.size() / 2 - 1);
    int i = 0;
    int j = list.size() - 1;
    while (i < j){
        while (list.get(i).compareTo(pivot) < 0){
            i++;
        }
        while (list.get(j).compareTo(pivot) > 0 && j > i){
            j--;
        }
        if (i <= j) {
            Collections.swap(list, i, j);
            i++;
            j--;
        }
    }
    if (0 < j)
        serialSort(list.subList(0, j + 1));
    if (i < list.size())
        serialSort(list.subList(i, list.size()));
}