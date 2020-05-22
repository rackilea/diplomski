class ReversedOrdering implements Comparator<Integer> {
    public int compare(Integer lhs, Integer rhs) {
        // compare reversed
        return rhs.compareTo(lhs);
    }
}