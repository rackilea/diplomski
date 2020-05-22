static bool IsMultipleOf3(uint x)
{
    const uint lookuptable = 0x49249249;
    uint t = (x & 0x0F0F0F0F) + ((x & 0xF0F0F0F0) >> 4);
    t = (t & 0x00FF00FF) + ((t & 0xFF00FF00) >> 8);
    t = (t & 0x000000FF) + ((t & 0x00FF0000) >> 16);
    t = (t & 0xF) + ((t & 0xF0) >> 4);
    return ((lookuptable >> (int)t) & 1) != 0;
}