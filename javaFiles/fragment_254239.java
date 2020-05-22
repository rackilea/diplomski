uint32_t div10(uint16_t in)
{
    // divides by multiplying by 52429 / (2 ^ 16)
    // 52429 = 0xcccd
    uint32_t x = in << 2;    // multiply by 4   : total = 0x0004
    x += (x << 1);           // multiply by 3   : total = 0x000c
    x += (x << 4);           // multiply by 17  : total = 0x00cc
    x += (x << 8);           // multiply by 257 : total = 0xcccc
    x += in;                 // one more makes  : total = 0xcccd

    return x >> 19;
}