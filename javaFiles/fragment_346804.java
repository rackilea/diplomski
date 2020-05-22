double value = 4.10;
//convert double to BigDecimal
BigDecimal bigDecimalValue = BigDecimal.valueOf(value);
BigDecimal tempValue = bigDecimalValue.setScale(2, RoundingMode.CEILING);
//convert to String
System.out.println(tempValue.toPlainString()); //5.40