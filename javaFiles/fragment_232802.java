public static int SetBit(final int Value, final byte Bit)
{
    assert bit >= 0;
    assert bit <= 31;   
    final int shift = 1 << Bit;
    return Value | shift;
}