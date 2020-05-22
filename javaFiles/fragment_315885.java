public static void main(String[] args) {
    Set<Object> bars = new HashSet<Object>();
    Bar bar1 = new Bar(1, 2);
    Bar bar2 = new Bar(1, 3);

    bars.add(bar1);
    bars.add(bar2); // no effect since bar1.equals(bar2)
    // only bar1 in the set

    bars.remove(bar2); // removes bar1 since bar1.equals(bar2)
    bars.add(bar2);
    // only bar2 in the set
}

static class Bar {
    int field1;
    int field2;

    public Bar(int field1, int field2) {
        this.field1 = field1;
        this.field2 = field2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bar)) return false;
        Bar bar = (Bar) o;
        return field1 == bar.field1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1);
    }
}