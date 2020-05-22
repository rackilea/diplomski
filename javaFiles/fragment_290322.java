DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.US);
DecimalFormat formatter = new DecimalFormat("##.####E0", symbols);
ComplexFormat cfWithE = new ComplexFormat(formatter);
Complex c2 = cfWithE.parse(entry.replace('e', 'E'));
System.out.println(c2);
//(-7.5212E-6, 3.4298E-6)