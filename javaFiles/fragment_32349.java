String mytotal = "362073133410.28625";                                     
System.out.println(mytotal);

// Convert String to float 
BigDecimal result = new BigDecimal(mytotal);
System.out.println(result+ " convert valueOf to int");

// round of to million  

 System.out.println(result.divide(new BigDecimal("1000000")).setScale(0, RoundingMode.HALF_UP)+" Result 1");

// System.out.println(result.divide(new BigDecimal("1000000000")).setScale(3, RoundingMode.HALF_UP)+" Result 1");