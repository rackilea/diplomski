List<Integer[]> arrays = new ArrayList<>();

arrays.add(new Integer[]{1, 2});
arrays.add(new Integer[]{3, 4});

Collections.sort(arrays, new Comparator<Integer[]>() {
    public int compare(Integer[] a, Integer[] b) {
        return 1; // FIX this according to your needs
    }
});