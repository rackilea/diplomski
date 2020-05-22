Arrays.sort(a, new Comparator<Integer>() {
    public int compare(Integer a1, Integer a2) {
        String s1 = "" + a1;
        String s2 = "" + a2;
        return s1.compareTo(s2);
    }
});