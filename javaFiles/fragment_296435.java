DecimalFormat f = new DecimalFormat("#,###");
    DecimalFormatSymbols fs = f.getDecimalFormatSymbols();
    fs.setGroupingSeparator('.');
    f.setDecimalFormatSymbols(fs);
    String s = f.format(12345678);
    System.out.println(s);