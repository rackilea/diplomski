class Data implements Comparable<Data> {
    private String rule;
    private String other;
    private int priority;

    ...

    @Override
    public int compareTo(Data other) {
        return Integer.compare(priority, other.priority);
    }
}