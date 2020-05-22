long number = 32301672060L;

    NumberFormat nb = NumberFormat.getNumberInstance(Locale.GERMAN);
    nb.setMinimumFractionDigits(2);

    System.out.println(nb.format((double)number/100));