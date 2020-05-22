NumberFormat nf = NumberFormat.getNumberInstance();
nf.setMaximumFractionDigits(100);

double x = 0.00000032d;
System.out.println(x);
System.out.println(nf.format(x));