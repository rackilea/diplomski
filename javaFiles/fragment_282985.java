public static void main(String[] args) {
    System.out.println("Enter value:");
    Scanner sc = new Scanner(System.in);
    while (sc.hasNext()) {
        boolean hasPerfectSquare = false;
        int input = sc.nextInt();
        if (input == -1) {
            break;
        }
        for (int i = input; i > 0; i--) {
            if (Math.floor(Math.sqrt(i)) == Math.sqrt(i)) {
                hasPerfectSquare = true;
                System.out.println((int) Math.sqrt(i));
                break;
            }
        }
        if (!hasPerfectSquare) {
            System.out.println("No perfect square");
        }
        System.out.println("Enter value:");
    }
}