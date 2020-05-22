public static boolean search(int value, int[] data, int start, int end) {
    int len = end - start + 1 ;
    int mid = (start + end) / 2;
    if (len == 1) {
        return false;
    } else {
        if (data[mid] == value) {
            return true;
        } else {
            if (data[mid] < value) {
                return search(value, data, mid + 1, end);
            } else {
                return search(value, data, start, mid - 1);
            }
        }
    }
}