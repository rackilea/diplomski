public static void main(String[] args) throws Exception {
    Scanner input = new Scanner(System.in);

    System.out.print("How many pairs do you want to enter? ");
    int numberOfPairs = input.nextInt();
    int[] sums = new int[numberOfPairs];

    for (int i = 0; i < numberOfPairs; i++) {
        int[] numbers = new int[2];
        for (int j = 0; j < numbers.length; j++) {
            // Be sure to enter two numbers with a space in between
            numbers[j] = input.nextInt();
        }
        sums[i] = numbers[0] + numbers[1];
    }

    System.out.println("Answers:");
    for (int sum : sums) {
        System.out.print(sum + " ");
    }
}