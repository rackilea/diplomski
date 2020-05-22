class StringCount implements Comparable<StringCount> {
    private final String string;
    private final int count;

    public StringCount(String string, int count) {
        this.string = string;
        this.count = count;
    }

    @Override
    public int compareTo(StringCount right) {
        return this.count < right.count ? -1
             : this.count > right.count ? 1
             : 0;
    }

    // implement equals and hashCode too
    // if a.compareTo(b) == 0, then a.equals(b) should return true.

}