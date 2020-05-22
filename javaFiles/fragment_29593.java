int bits(int n, int offset, int length)
{
    //shift the bits rightward, so that the desired chunk is at the right end
    n = n >> (31 - offset - length); 

    //prepare a mask where only the rightmost `length`  bits are 1's
    int mask = ~(-1 << length);

    //zero out all bits but the right chunk
    return n & mask;
}