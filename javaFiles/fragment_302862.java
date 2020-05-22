public string bCount()
{
  for (int indexOfGuess = 0; indexOfGuess < answer.length(); indexOfGuess++)
  {
     for (int indexOfActualNumber = 0; indexOfActualNumber < answer.length(); indexOfActualNumber++)
     {
       if (guess.charAt(indexOfGuess).equals(answer.charAt(indexOfActualNumber))
       {
          bCount++;
       }
     }
  }
}