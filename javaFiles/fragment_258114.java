import java.text.DecimalFormat;

...

DecimalFormat df = new DecimalFormat("#.##");
double num = 10.1234;
double newNum = Double.parseDouble(df.format(num));
System.out.println(newNum);