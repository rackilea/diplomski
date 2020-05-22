public static long euclid(int a, int b) {
    if (b == 0) {
        return a;
    }
    return euclid(b, a%b);
}

public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter a positive integer: ");
    int a = Integer.parseInt(scanner.nextLine().trim());
    System.out.print("Enter another positive integer: ");
    int b = Integer.parseInt(scanner.nextLine().trim());
    // Call euclid, and Fix the format string.
    System.out.printf("The greatest common divisor is: %d.", euclid(a,b));
}