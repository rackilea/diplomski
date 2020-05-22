double num = 2.0170818E7; 
    int dp = 4;
    BigDecimal pow = new BigDecimal(Math.pow(10, dp));
    BigDecimal bigDecimal = new BigDecimal(num);
    BigDecimal result = bigDecimal.multiply(pow);
    result = result.divide(pow);
    String s = result.toString();