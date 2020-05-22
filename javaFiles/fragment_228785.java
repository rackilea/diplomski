private Long seed = 0L;

protected synchronized int next(int bits){
    seed = (seed * 0x5DEECE66DL + 0xBL) & ((1L << 48) - 1);
    System.out.println(seed);
    return (int) (seed >>> (48 - bits));
}