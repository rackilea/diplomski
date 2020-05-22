private static boolean binary_search(int[] iterable, int item) {
    if (iterable.length == 0) {
        return false;
    }
    return binary_search(iterable, item, 0, iterable.length);
}

private static boolean binary_search(int[] iterable, int item, int start, int end) {
    int mid_point = (start + end) / 2;
    if (iterable[mid_point] == item){
        return true;
    } else if (start == end) {
        return false;
    }
    else if (iterable[mid_point] > item){
        return binary_search(iterable, item, start, mid_point);
     }
     else {
        return binary_search(iterable, item, mid_point+1, end);
    }
}