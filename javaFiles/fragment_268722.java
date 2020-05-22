void set(int n, byte[] bitField, boolean value)
{
    if(value)
        bitField[n >> 3] |= 1 << (n & 0x7);
    else
        bitField[n >> 3] &= ~(1 << (n & 0x7));
}