// one way to do it
// %.3f is for a floating number with 3 digits to the right of the decimal
// %n is for new line
System.out.printf(%.3f%n, num); 

Another:
DecimalFormat decimalFormat = new DecimalFormat("0.000");
System.out.println(decimalFormat.format(num));