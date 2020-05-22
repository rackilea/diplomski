static class ImmutableAverager {
    private final int total;
    private final int count;

    public ImmutableAverager() {
        this.total = 0;
        this.count = 0;
    }

    public ImmutableAverager(int total, int count) {
        this.total = total;
        this.count = count;
    }

    public double average() {
        return count > 0 ? ((double) total) / count : 0;
    }

    public ImmutableAverager accept(int i) {
        return new ImmutableAverager(total + i, count + 1);
    }

    public ImmutableAverager combine(ImmutableAverager other) {
        return new ImmutableAverager(total + other.total, count + other.count);
    }
}