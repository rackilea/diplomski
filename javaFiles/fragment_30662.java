int largest = Integer.MIN_VALUE;
int value = 0;
for (int i = 0; i <= 4; i++) {
    value = input.nextInt();
    if (value > largest) {
        largest = value;
    }
}
System.out.println(largest);