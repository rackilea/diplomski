double x = 22.44;
DecimalFormat df = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.FRANCE));
System.out.println(df.format(x));

df = new DecimalFormat("0.00", new DecimalFormatSymbols(Locale.UK));
System.out.println(df.format(x));