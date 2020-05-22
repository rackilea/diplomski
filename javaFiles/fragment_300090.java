public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int x = scan.nextInt();
    int y = x + 1;
    int z = x + 2;
    boolean areConsecutive = false;

    while (x != -1) {
        x = scan.nextInt();
        if (x == y) {
            x = scan.nextInt();
            if (x == z)
                areConsecutive = true;
        }
        y = x + 1;
        z = x + 2;
    }
    if (areConsecutive)
        System.out.print("Consecutive");
    else
        System.out.print("None Consecutive");
}