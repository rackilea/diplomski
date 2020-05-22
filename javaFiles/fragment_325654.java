Collections.sort(arr, new Comparator<Integer>() {
    public int compare(Integer e1, Integer e2) {
        if (e1 % 10 == 0 && e2 % 10 != 0 || (e2 % 10 == 0 && e1 % 10 != 0) || e1 % 10 == 0 || e2 % 10 == 0) {
            return 0;
        } else {
            if (e1 % 10 < e2 % 10) {
                return 1;
            } else {
                return -1;
            }
        }
    }
});