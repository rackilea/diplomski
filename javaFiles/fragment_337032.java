public enum Side
{
    LEFT('l'),
    RIGHT('r');

    private byte byteValue;

    private Side(byte byteValue)
    {
        this.byteValue = byteValue;
    }

    public byte getByteValue()
    {
        return byteValue;
    }

    public static Side findByByteValue(byte value)
    {
        for(Side side : values())
        {
            if(side.byteValue == value)
            {
                return side;
            }
        }
        return null;
    }
}