String number = "-123456.799999";
    double realnumber = Double.parseDouble(number);
    NumberFormat nf = NumberFormat.getInstance(Locale.US);
    nf.setMaximumFractionDigits(10);  
    System.out.printf("%s", nf.format(realnumber));
    // System.out.println(nf.format(realnumber)); // both work