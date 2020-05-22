final int max = 1000003;
BigInteger [] fact = new BigInteger[max];
BigInteger mod = BigInteger.valueOf(max);
BigInteger x = ...; // computed somewhere
BigInteger y = ...; // computed somewhere

BigInteger temp = 
   fact[x.intValue()]          // x is a BI, take intValue() to access array element
     .multiply(                // operands are BI
        fact[x.subtract(y)     // operands are BI
                 .intValue()]) // take intValue() to access array
                    .mod(mod); // operands are BI, result is BI