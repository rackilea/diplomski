String input = "1_3_34_12_1_2_34";
String[] numbers = input.split("_");
Arrays.sort(numbers);
int count = -1;
String last = numbers[0];
for (String n : numbers) {
    count++;
    if (n.equals(last)) continue;
    System.out.print(last + '_' + count + ',');
    last = n;
    count = 0;
}
count++;
System.out.println(last + '_' + count);