enum Category {
  private final int score;
  
  ONES(1) { 
    public int score() { 
      int computedScore = 0;
      for (int i = 0; i < 4; i++) {
       if (diceArray[i] == ONES) {
          println(computedScore);
          computedScore++;
       }
      }
      return computedScore;
    }
  },
  SIXES(6);

  private Category(int score) { this.score = score; }

  public int score() { return this.score; }
}