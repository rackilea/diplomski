public static void main(String args[]) {
    System.out.print("Enter the numbers of rows you want to print: ");
    Scanner scan = new Scanner(System.in);
    int n = scan.nextInt();
    // Print lines 1 to n-1
    for (int i = 1; i < n; i++) { // count up (i = 1 .. n-1)
        for (int j = 0; j < i; j++) { // count up (j = 0 .. i-1)
            System.out.print((char)('A' + j));
        }
        for (int j = 1; j < 2 * (n - i); j++) { // odd number of spaces
            System.out.print(' ');
        }
        for (int j = i - 1; j >= 0; j--) { // count down (j = i-1 .. 0)
            System.out.print((char)('A' + j));
        }
        System.out.println();
    }
    // Now print last line
    for (int j = 0; j < n; j++) { // count up (j = 0 .. n-1)
        System.out.print((char)('A' + j));
    }
    for (int j = n - 2; j >= 0; j--) { // count down (j = n-2 .. 0)
        System.out.print((char)('A' + j));
    }
    System.out.println();
}