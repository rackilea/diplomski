public void wins(int []player1Scores, int []player2Scores)
{
    int player1Wins = 0;
    int player2Wins = 0;

    for (int i = 0; i < 10; i++)
        (player1Scores > player2Scores) ? player1Wins++ : player2Wins++;

    System.out.printf("Player 1 wins: %-10i Player 2 wins %-10i", player1Wins, player2Wins);
}//End wins