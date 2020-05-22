public static void multiplicationTable(int size) {
    for (int i = 1; i <= size; i++) {
        for (int j = 1; j <= size; j++) {
            System.out.print("\t" + i * j);
        }
        System.out.println();
    }
}

public static void main(String[] args) throws Exception {
    System.out.println("This program displays a multiplication table.");
    Scanner size = new Scanner(System.in);
    System.out.println("Enter a positive integer: ");
    int n = size.nextInt();
    multiplicationTable(n);
}