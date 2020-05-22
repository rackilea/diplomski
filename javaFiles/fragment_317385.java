BigInteger result = base.pow(power);
        BigInteger div = new BigInteger("10");
        System.out.println(result);
//The following line is different, initialize the sum before using it.
        BigInteger sum = BigInteger.ZERO;
        while(!BigInteger.ZERO.equals(result)) {
            BigInteger digit = result.mod(div);
            result = result.divide(div);
            sum = sum.add(digit);
        }
        System.out.println(sum);