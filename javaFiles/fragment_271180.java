public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n;
    int sum = 0;
    int count = 0;
    do {
        System.out.print("Enter a number: ");
        n = scanner.nextInt();
        System.out.println("Your number is " + n);

        sum += n;
        count++;
    } while (n != 0);

    System.out.println("The average is : " + ((double) sum) / (count - 1));

    scanner.close();
}