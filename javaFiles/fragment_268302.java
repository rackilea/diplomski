Arrays.sort(array, new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
        Arrays.sort(o1);
        Arrays.sort(o2);
        for (int i = 0; i < o1.length && i < o2.length; i++) {
            if (o1[i] != o2[i]) {
                return o1[i] < o2[i] ? -1 : 1;
            }
        }
        if (o1.length != o2.length) {
            return o1.length < o2.length ? -1 : 1;
        }
        return 0;
    }
});