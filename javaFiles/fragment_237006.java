public static void main(String str[]) throws IOException {
    Scanner input = new Scanner(System.in);

    for (int counter = 0; counter < 10; counter++) {
        System.out.printf("Enter first integer for counter %d: ", counter);
        int number1 = input.nextInt();

        System.out.printf("Enter second integer for counter %d: ", counter);
        int number2 = input.nextInt();

        // Since you want to print true if number1 is a multiple of number2.
        System.out.println(number1 % number2 == 0);
    }
}