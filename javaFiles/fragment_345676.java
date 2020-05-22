if (stones <= 4 && stones > 0) {
    System.out.println ("\nYou picked " + stones);
    heapSize = (heapSize - stones);

    if (heapSize > 0) {
        System.out.println ("\nThere are " + heapSize + " stones left\n\n");  

        // Could use a ternary operator here:
        // player = (player.equals(player1) ? player2 : player1);

        if (player.equals(player1)) {
            player = player2;
        }
        else {
            player = player1;
        }
    }
    else {
        if (player.equals(player1)) {
            System.out.println("Player 1 wins!");
        }
        else {
            System.out.println("Player 2 wins!");
        }       
    }
}