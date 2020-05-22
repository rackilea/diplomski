public enum CharEnum
{
    // Other code as before

    public boolean overlapsWith(CharEnum ch)
    {
        return (ch.mask & mask) > 0;
    }
}