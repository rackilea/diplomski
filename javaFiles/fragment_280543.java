public static int findClosest(TreeSet set, Integer val) {
    if (set == null || set.size() == 0) {
        return -1;
    }

    // ceiling == 9 for input of 7
    // O(lg n) operation
    Integer ceiling = (Integer)set.ceiling(val);
    // floor = 6 for input of 7
    // O(lg n) operation
    Integer floor = (Integer)set.floor(val);

    if (ceiling == null) {
        return val - floor;
    }
    if (floor == null) {
        return ceiling - val;
    }

    return (val - floor > ceiling - val) ? ceiling - val : val - floor;
}

public static void main(String[] args) {
    TreeSet<Integer> ts = new TreeSet<>();
    ts.add(5);
    ts.add(1);
    ts.add(6);
    ts.add(9);
    ts.add(2);
    ts.add(3);

    int diff = findClosest(ts, 7);
    // closest is 6, so diff == 1
}