class MyComparator implements Comparator<Integer> {

    private final int b;

    public MyComparator(int b) { this.b = b; }

    public int compare(Integer o1, Integer o2) {
        Integer i1 = Math.abs(o1 - b);
        Integer i2 = Math.abs(o2 - b);
        return i1.compareTo(i2);
    }
}