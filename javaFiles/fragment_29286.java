public String toDecimalString() {

    var result = new StringBuilder();

    var remainders = new HashMap<BigInteger, Integer>();

    if(!isNonNegative()) result.append("-");
    var divAndRem = numerator.abs().divideAndRemainder(denominator);
    result.append(divAndRem[0].toString());

    if(isWholeNumber()) return result.toString();

    result.append(".");

    int currentPosition = result.length();
    remainders.put(divAndRem[1], currentPosition);

    while(!divAndRem[1].equals(BigInteger.ZERO)) {
        divAndRem = divAndRem[1].multiply(BigInteger.TEN).divideAndRemainder(denominator);
        result.append(divAndRem[0].toString());
        if(remainders.containsKey(divAndRem[1])) {
            int periodStart = remainders.get(divAndRem[1]);
            return result.substring(0, periodStart)+"["+result.substring(periodStart)+"]";
        }
        remainders.put(divAndRem[1], ++currentPosition);
    }

    return result.toString();

}