public enum GameState{
  INSTANCE;

  private int score;
  private GameState(){
    score = 0;
  }

  public int getScore(){
    return score;
  }
  public void addScore(int score){
    this.score += score;
  }

}