NumberFormat canadaFrench = NumberFormat.getCurrencyInstance(Locale.CANADA_FRENCH);
NumberFormat canadaEnglish = NumberFormat.getCurrencyInstance(Locale.CANADA);

BigDecimal amount = new BigDecimal("123456789.99");

System.out.println(canadaFrench.format(amount));
System.out.println(canadaEnglish.format(amount));