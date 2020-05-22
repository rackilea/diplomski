public static <T extends Comparable<? super T>> boolean check(List<List<T>> list) {
    if(list.size() < 2) return true;

    for(int i = 1; i < list.size(); i++) {
        List<T> previous = list.get(i-1);
        List<T> item = list.get(i);

        if(notEqual(previous, item)){
            return true;
        }
    }

    return false;
}