int[] numbers = new int[25];
for (int i = 0; i < numbers.length; i++) {
    numbers[i]=i+1;

    System.out.print(numbers[i]);
    if (numbers[i] % 5 == 0 && i > 0) {
        System.out.println();
    } else {
        System.out.print(",");
    }
}