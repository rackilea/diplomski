BigInteger[] bigIntegers = new BigInteger[rlwe_table.length];

for(int i=0; i<rlwe_table.length; i++){
    BigInteger big = BigInteger.valueOf(0);
    for(int j=0; j<rlwe_table[i].length; j++){
        big = big.or(new BigInteger(Long.toHexString(rlwe_table[i][j]),16).shiftLeft(j*64));
    }
    bigIntegers[i] = big;
}