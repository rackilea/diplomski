int[] numbers = {1, 5, 3};
// then you can print out the curly braces
System.out.print("{");
for (int i = 0; i < numbers.length; i++) {
    System.out.print(i);
    if (!(i == numbers.length-1)) System.out.print(",");
}
System.out.print("}");