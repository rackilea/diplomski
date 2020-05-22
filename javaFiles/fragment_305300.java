final int number0 = Integer.parseInt("000", 2);
final int number1 = Integer.parseInt("1", 2);
final int sum = number0 + number1;

int len = 3;

String output = String.format("%" + len + "s", Integer.toBinaryString(sum))
        .replace(' ', '0');
System.out.println(output); // 001