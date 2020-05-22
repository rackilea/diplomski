int[][] temp = { { 1, 50, 5 }, { 2, 30, 8 }, { 3, 90, 6 },
        { 4, 20, 7 }, { 5, 80, 9 }, };
Arrays.sort(temp, new Comparator<int[]>() {
    @Override
    public int compare(int[] o1, int[] o2) {
        return Integer.compare(o2[1], o1[1]);
    }
});