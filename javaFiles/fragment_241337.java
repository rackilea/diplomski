public static void main(String[] args) {
    Scanner o = new Scanner(System.in);
    System.out.print("Input max match: ");
    int q = o.nextInt();
    int maxDiff = 0;
    int maxWinner = 0;

    for (int i = 0; i < q; i++) {   // q is the number of turns
        System.out.println("Match " + String.valueOf(i + 1));
        System.out.print("1st player: ");
        int player1Input = o.nextInt();   //first player input
        System.out.print("2st player: ");
        int player2Input = o.nextInt();   //second player input
        int diff = Math.abs(player1Input - player2Input);   //getting the difference
        int winner = (player1Input > player2Input) ? 1 : 2;   //picking the winner for the turn

        if(diff > maxDiff) {
            maxDiff = diff;
            maxWinner = winner;
        }
    }

    if(maxWinner > 0) {
        System.out.printf("Winner player: %d Max diff: %d", maxWinner, maxDiff);
    }
}