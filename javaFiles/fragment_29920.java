public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println("Enter amount due: ");
    int amount = input.nextInt();

    System.out.println("Amount tendered: ");
    int tmp = input.nextInt();

    int change;

    int diff = tmp - amount;
    if (diff % 50 == 0) {
        change = diff / 50;
        System.out.println(change + " $50 bills");

    } 
    else if (diff % 20 == 0) {
        change = diff / 20;
        System.out.println(change + " $20 bills");

    }
}