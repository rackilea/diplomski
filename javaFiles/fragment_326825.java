NumberFormat numberFormat = NumberFormat.getInstance();
numberFormat.setMinimumIntegerDigits(5);
numberFormat.setMaximumIntegerDigits(5);
numberFormat.setGroupingUsed(false);
String numberString = numberFormat.format((long) 7789);

System.out.println(numberString);  //"07789"