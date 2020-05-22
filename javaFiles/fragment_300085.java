public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Number of integers to enter:");
    int numberEnter = keyboard.nextInt();
    int numbers[] = new int[numberEnter];
    int pos = 0;
    do {
        System.out.printf("Please enter integer #%d/%d:%n", pos, numberEnter);
        numbers[pos++] = keyboard.nextInt();
    } while (pos < numberEnter && keyboard.hasNextInt());
    int min = numbers[0];
    int max = numbers[0];
    for (pos = 1; pos < numbers.length; pos++) {
        if (numbers[pos] < min) { // <-- test min.
            min = numbers[pos];
        }
        if (numbers[pos] > max) { // <-- test max.
            max = numbers[pos];
        }
    }
    // Display everything.
    System.out.printf("%s Min: %d Max: %d%n", Arrays.toString(numbers),
            min, max);
}