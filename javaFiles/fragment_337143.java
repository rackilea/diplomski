public static void main(String args[]) {
    Scanner kb = new Scanner(System.in);
    System.out.println("Enter minimum range : ");
    int b = kb.nextInt();
    System.out.println("Enter maximum range : ");
    int a = kb.nextInt();
    kb.close();
    System.out.println("Perfect number in the given range are :");
    for (int n = b; n <= a; n++) {
        int sum = 0;
        int i = 1;
        while (i < n) {
            if (n % i == 0)
                sum = sum + i;
            i++;
        }
        if (sum == n)
            System.out.println(n + " is perfect");

    }
}