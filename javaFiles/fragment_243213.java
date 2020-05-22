if (scores[0] >= 0 && scores[0] <= 100 || 
    scores[1] >= 0 && scores[1] <= 100 ||
    scores[2] >= 0 && scores[2] <= 100)
{
    average = totalScores / 3;        
    System.out.println("Average Score: " + average);
}
else 
{
   throw new IllegalArgumentException("Numbers were too low or high.");
}