static BigInteger fact(BigInteger num) {
        if (num.equals(BigInteger.ONE))
            return BigInteger.ONE;
        else
            return num.multiply(fact(num.subtract(BigInteger.ONE)));
    }