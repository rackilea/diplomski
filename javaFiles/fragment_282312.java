public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("Enter number: ");
    int number = in.nextInt();
    int sum = 0;
    int v = 0;
    while (v <= number) {
        sum += v;
        v++;
    }
    System.out.println("Sum is: " + sum);
}