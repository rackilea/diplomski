final DecimalFormatSymbols syms = new DecimalFormatSymbols();
syms.setDecimalSeparator(',');
syms.setGroupingSeparator('.');
DecimalFormat myFormatter = new DecimalFormat("", syms);
myFormatter.applyLocalizedPattern("###.###,00");
System.out.println(myFormatter.format(1234.12));