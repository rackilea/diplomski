String input = "A1B2000C";
String number = input.replaceAll(".*(?<=\\D)(\\d+)\\D*", "$1");
int next = Integer.parseInt(number);
next++;
String ouput = input.replaceAll("(.*)(?<=\\D)\\d+(\\D*)", "$1" + next + "$2");
System.out.println(ouput);