class CellPosition
{
    private static final Interner<CellPosition> CACHE = Interners.newStrongInterner();
    // or .newWeakInterner(), to allow instances to be garbage collected

    private final int x;
    private final int y;

    private CellPosition(int x, int y)
    {
        this.x = x;
        this.y = x;
    }

    public int x() { return x; }
    public int y() { return y; }

    public static CellPosition at(int x, int y)
    {
        return CACHE.intern(new CellPosition(x, y));
    }

    @Override
    public boolean equals(Object other) {/* TODO */}

    @Override
    public int hashCode() {/* TODO */}
}