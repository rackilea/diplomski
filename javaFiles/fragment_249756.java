class Triple {
    private final int x, y, z;
    private final int[] sorted;

    public Triple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.sorted = new int[] {x, y, z};
        Arrays.sort(sorted);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Triple
                && Arrays.equals(((Triple)obj).sorted, this.sorted);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(sorted);
    }
}