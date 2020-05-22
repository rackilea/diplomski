class NMOS extends Transistor
{
    boolean open;

    public NMOS(BinaryDigit b)
    {
        open = b.digit == 1;
    }

    public void setInput(BinaryDigit b)
    {
        open = b.digit == 1;
    }

    public boolean isOpen()
    {
        return open;
    }

    public boolean isClosed()
    {
        return !open;
    }
}