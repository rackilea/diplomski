BigInteger result = base.pow(power);
    BigInteger div = BigInteger.valueOf(10);
    System.out.println(result);

    //Initialize the sum to zero
    BigInteger sum = BigInteger.ZERO;        
    //While the result has a non-zero decimal digit
    while(!BigInteger.ZERO.equals(result)) {
        //this divides by ten (first element),
        //and calculates the remainder (second element)
        BigInteger[] lastDigit = result.divideAndRemainder(div);
        result = lastDigit[0];
        sum = sum.add(lastDigit[1]);

    }
    System.out.println(sum);