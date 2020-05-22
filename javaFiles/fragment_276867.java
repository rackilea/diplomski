int coldif(int c1,int c2)
{
    return (Math.abs((c1&0x0000ff) - (c2&0x0000ff))      ) +
           (Math.abs((c1&0x00ff00) - (c2&0x00ff00)) >>  8) +
           (Math.abs((c1&0xff0000) - (c2&0xff0000)) >> 16);
}