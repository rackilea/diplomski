/* This is big enough for 16 pairs of on_off and pos_neg */
/* In a pair of bits, bit 0 = on_off, bit 1 = pos_neg */
uint32_t cmdData;

/* Get values of on_off and pos_neg for element number n */
void getData(int n, bool& on_off, bool& pos_neg)
{
    uint32_t shifted = cmdData >> (2 * n);
    on_off = (shifted & 1) != 0;
    pos_neg = (shifted & 2) != 0;
}

/* Store values for element n */
void setData(int n, bool on_off, bool pos_neg)
{
    uint32_t bits = (int)on_off + (2 * (int)pos_neg); 
    uint32_t mask = 3 << (n * 2);
    cmdData &= ~mask; /* Clear bits */
    cmdData |= bits << (n * 2);
}