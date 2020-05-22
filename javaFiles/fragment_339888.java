public int move() {  // make it so they can only choose 1-9
    System.out.print("Where do you want to move? ");
    Scanner in = new Scanner(System.in);
    int move = in.nextInt();
    while (move < 1 || move > 9) {
         System.out.println("that move is invalid must be 1-9");
         move = in.nextInt();
    }
    return move;
}