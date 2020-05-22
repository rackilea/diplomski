BigDecimal a = new BigDecimal("-54125412512.231515235346");
BigDecimal b = new BigDecimal("-1231254125412512.231515235346");

NumberFormat formatter = new DecimalFormat("#,###");
formatter.setRoundingMode(RoundingMode.HALF_UP);
formatter.setMinimumFractionDigits(4);
formatter.setMaximumFractionDigits(4);
System.out.println("Number : " + formatter.format(a));
System.out.println("Number : " + formatter.format(b));