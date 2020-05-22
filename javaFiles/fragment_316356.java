next.replaceAll((p, k)->{

    for(; k[0] < finalK; k[0] += p)
        seg[(int) (k[0] >>> S)] |= (1L << (k[0] & BMASK));

    for(; k[1] < finalK; k[1] += p)                         
        seg[(int) (k[1] >>> S)] |= (1L << (k[1] & BMASK));

    return new long[]{k[0]-finalK, k[1]-finalK});
});