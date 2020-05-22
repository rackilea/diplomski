NumberFormat format_english = NumberFormat.getInstance(Locale.ENGLISH);
NumberFormat format_france = NumberFormat.getInstance(Locale.GERMAN);
Number number1 = format.parse("33445.0");
Number number2 = format.parse("33.445,00");
double d1 = number1.doubleValue();  // or whatever value you're looking for
double d2 = number2.doubleValue();
// now compare them as any two "normal" numbers