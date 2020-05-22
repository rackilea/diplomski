public static class FixableArrayList<T> extends ArrayList<T> {

    // ascending and descending views of the fixed indices
    private final SortedSet<Integer> fixedAsc;
    private final SortedSet<Integer> fixedDec;

    public FixableArrayList() {
        TreeSet<Integer> treeSet = new TreeSet<>();
        fixedAsc = treeSet;
        fixedDec = treeSet.descendingSet();
    }

    public boolean addFixedIndex(int ind) { return fixedAsc.add(ind); }
    public boolean removeFixedIndex(int ind) { return fixedAsc.remove(ind); }

    public void move(int fromInd, int toInd) {
        if (fromInd == toInd) {
            return;
        }
        if (fixedAsc.contains(fromInd)) {
            throw new IllegalArgumentException("Cannot remove from fixed index: " + fromInd);
        }
        if (fixedAsc.contains(toInd)) {
            throw new IllegalArgumentException("Cannot add to fixed index: " + toInd);
        }

        super.add(toInd, super.remove(fromInd));

        if (toInd < fromInd) {
            // all between `from` and `to` shifted up, swap fixed indices down back into position
            // iterate from low (toInd) to high (fromInd)
            for (int i : fixedAsc.subSet(toInd, fromInd)) {
                super.add(i, super.remove(i + 1));
            }
        } else {
            // all between `from` and `to` shifted down, swap fixed indices up back into position
            // iterate from high (toInd) to low (fromInd)
            for (int i : fixedDec.subSet(toInd, fromInd)) {
                super.add(i, super.remove(i - 1));
            }
        }
    }
}

public static void main(String[] args) {
    FixableArrayList<Integer> values = new FixableArrayList<>();
    values.addAll(Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100));

    // set the indices that you want to remain fixed
    values.addFixedIndex(3);
    values.addFixedIndex(5);
    values.addFixedIndex(9);

    System.out.println(values);

    values.move(0, 8);
    System.out.println(values);

    values.move(8, 0);
    System.out.println(values);
}