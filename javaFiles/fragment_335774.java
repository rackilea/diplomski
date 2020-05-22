public static void main(String[] args) {
    try (Scanner scan = new Scanner(System.in)) {
        System.out.println("Sum = 1^0-x^1+x^2-x^3..+x^n");
        System.out.println("Enter number X");
        int x = 0;
        while (true) {
            try {
                x = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Enter an integer.");
            }
        }
        System.out.println("Enter number N");
        int n = 0;
        while (true) {
            try {
                n = Integer.parseInt(scan.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Enter an integer.");
            }
        }
        double sum = 0;
        for (int i = 0; i <= n; i++) {
            if (i % 2 == 0)    // if I is even
                sum = sum + Math.pow(x, i);
            else    // if I is odd
                sum = sum - Math.pow(x, i);
        }
        System.out.println("Z is " + sum);
    }
}