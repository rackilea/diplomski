//This is just an object that can format numeric values into strings...
DecimalFormat df = new DecimalFormat("#.000");

//computation
long factor = (long) Math.pow(10, places);
value = value * factor;
long tmp = Math.round(value);
double result = (double) tmp / factor;

//formatting to string of specified format
String formattedValue = df.format(result);

//optional...
System.out.println(formattedValue);