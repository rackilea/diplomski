if(t < 0) // (i*j > 32767 )
{
    t &= (short)0x7FFF;
    t += 64;  // hack because n is always 511
}
t %= n;