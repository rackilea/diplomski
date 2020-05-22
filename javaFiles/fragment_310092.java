BigDecimal a = new BigDecimal("4.3000");
BigDecimal b = new BigDecimal("4.0");

DecimalFormat f = new DecimalFormat("#.#");
f.setDecimalSeparatorAlwaysShown(false)
f.setMaximumFractionDigits(340);

System.out.println(f.format(a));
System.out.println(f.format(b));