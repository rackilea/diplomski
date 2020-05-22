double d1 = 12_345.678_90;
double d2 = 12_345.6;

// toString()
System.out.println("Double.toString: " + Double.toString(d1));
System.out.println("Double.toString: " + Double.toString(d2));

// one (not recommended) solution
// using proprietary sun.misc.FloatingDecimal and reflection
Field value = FloatingDecimal.class.getDeclaredField("nDigits");
value.setAccessible(true);

int numberOfDigits = (int) value.get(new FloatingDecimal(d1));
String format = "String.format  : %,." + numberOfDigits + "g";
System.out.println(String.format(FRENCH, format, d1));

numberOfDigits = (int) value.get(new FloatingDecimal(d2));
format = "String.format  : %,." + numberOfDigits + "g";
System.out.println(String.format(FRENCH, format, d2));

// another (not recommended) solution
numberOfDigits = Double.toString(d1).replaceAll("\\.", "").length();
format = "String.format  : %,." + numberOfDigits + "g";
System.out.println(String.format(FRENCH, format, d1));