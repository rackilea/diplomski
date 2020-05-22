Comparator<Integer> cmp = new Comparator<Integer>() {
    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 < o2) {
            return 1;
        } else {
            return -1;
        }
    }
};

Collections.sort(list, cmp);