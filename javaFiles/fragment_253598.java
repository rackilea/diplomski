DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("en", "US"));
symbols.setDecimalSeparator(',');
symbols.setGroupingSeparator('.'); 
DecimalFormat df = new DecimalFormat("$#,##0", symbols);
System.out.println(df.format(83000L));
//$83.000