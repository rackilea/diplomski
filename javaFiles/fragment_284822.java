class Score {
  int value;
  // ...
  public static int totalScore(Collection<Score> scores){ 
    int sum = 0;
    for (Score s: scores){
      sum += s.value;
    }
    return sum;
  }
}