for (int[] winningPosition : winningPositions) 
    {
        if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                gameState[winningPosition[0]] !=2 ) 
        {
            //Someone has won
            gameIsActive = false;

            String winner = "Red";
            if (gameState[winningPosition[0]] == 0) 
            {
                winner = "Yellow";
            }
            TextView winnerMsg = (TextView) findViewById(R.id.winnerMsg);
            winnerMsg.setText(winner + " has won!");
            LinearLayout layout = (LinearLayout)findViewById(R.id.playAgainLayout);
            layout.setVisibility(View.VISIBLE);
            break;
        }