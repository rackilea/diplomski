public static void main(String args[]) {
    int n = 0;
    Scanner in = new Scanner(System.in);

    System.out.println("Enter a number ");
    n = in.nextInt();
    for (int i = 1; i <= n; i++) {
        System.out.println(i + "\t" + Integer.toHexString(i).toUpperCase());
    }
}