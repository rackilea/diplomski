NumberFormat f = NumberFormat.getInstance(loc);
if (f instanceof DecimalFormat) {
  DecimalFormat df = (DecimalFormat) f;
  df.setGroupingUsed(true);
  df.setGroupingSize(3);
  System.out.println(df.format(myNumber));
}