String Amount = "123.786";
 String value= String.format("%.2f", Float.valueOf(Amount));

or 

BigDecimal value = new BigDecimal(Amount).setScale(2, BigDecimal.ROUND_HALF_UP);