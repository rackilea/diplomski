class OddArea
{
    static final int MAX_SELECTION_SIZE = 64; //Or whatever

    public final int xOffset, yOffset;

    // 256 = Chunk height
    public final boolean[][][] squares = new boolean[MAX_SELECTION_SIZE][MAX_SELECTION_SIZE][256];

    OddArea()
    {
        this(0, 0);
    }

    OddArea(final int xOffset, final int yOffset)
    {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

    void addBlock(final int x, final int y, final int z)
    {
        this.squares[x - this.xOffset][y - this.yOffset][z] = true;
    }

    boolean isInsideArea(final int x, final int y, final int z)
    {
        return this.squares[x - this.xOffset][y - this.yOffset][z];
    }
}