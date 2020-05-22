public static boolean search(ArrayList<Integer> list, int key) {
    int i = 0;
    while (i < list.size()) {
        if (list.get(i) == key) {
            return true;
        }
        i++;
    }
    return false;
}