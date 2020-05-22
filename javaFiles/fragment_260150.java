public enum CharEnum // Let's avoid java.lang.* clashes
{
    A(1), B(2), C(4), D(8);

    private final int mask;

    private CharEnum(int mask)
    {
        this.mask = mask;
    }

    public int getMask()
    {
        return mask;
    }
}