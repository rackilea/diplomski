System.out.println("Enter a number : ");
String input = in.nextString();
Class klass = Class.forName("java.lang." + input.split("\\.")[0]);
Field field = klass.getField(input.split("\\.")[1]);
int number = field.getInt(klass);
System.out.println("The number entered is : " + number);