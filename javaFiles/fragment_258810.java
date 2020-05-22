static boolean fourNumbersInARow(List<Integer> list) {
    int last = 0xFACADE;  // can be any number
    int count = 0;        // important!
    for (int i : list) {
        if (i == last + 1) {
            if (++count == 4) return true;
        } else {
            count = 1;
        }
        last = i;
    }
    return false;
}