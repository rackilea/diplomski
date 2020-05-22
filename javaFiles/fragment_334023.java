currentSumScore = player1Score + player2Score;
if (currentSumScore >= sumScores )
{
    //Actual sum is greater than previous
    sumScores = currentSumScore;
}

else
{
    //Do nothing, this line is not greater than one found before
    //This else is not needed
}