int j = 1;
for (BigInteger bigInt2 = BigInteger.ONE; ;bigInt2 = bigInt2.add(bigIntBase)) {
    // do your stuff inside for loop 

    // manually handle int counter
    if (j>1000000) break;
    else j++;
}