Double d1 = (Double)0.0;
Double d2 = (Double)2.2;
Double d3 = (Double)4.0;

// Example: Use four decimal places, but only if required
NumberFormat nf = new DecimalFormat("#.####");

String s1 = nf.format(d1); // 0
String s2 = nf.format(d2); // 2.2
String s3 = nf.format(d3); // 4