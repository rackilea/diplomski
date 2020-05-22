private static void scoreCalc(int targetScore, int score, int ballNumber,
    int itter)
{
    for(int i = itter; i < HOLEVALUES.length; i++)
    {
     ...
     if (ballNumber > 0) {
         scoreCalc(targetScore, score, ballNumber, i);
     ...
    }
}

private static void scoreCalc(int targetScore)
{
    scoreCalc(targetScore, 0, BALLCOUNT, 0);
}