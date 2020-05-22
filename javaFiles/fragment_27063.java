BigInteger two = new BigInteger("2");
BigInteger three = new BigInteger("3");
BigInteger I = new BigInteger(""+i); // "I" is a bigint version of "i"
nth[i] = I
    .multiply(I.add(BigInteger.ONE))
    .multiply(I.multiply(two).add(BigInteger.ONE))
    .multiply(I.multiply(I).multiply(three).add(I.multiply(three)).subtract(BigInteger.ONE))
    .divide(new BigInteger("30"));