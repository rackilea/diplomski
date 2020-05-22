public class Player {
  private final String name;
  private final int time;
  private final String grid;
  private final double score;

  public Player(String name, int time, String grid, double score) {
    this.name = name;
    this.time = time;
    this.grid = grid;
    this.score = score;
  }

  public double getScore() {
    return score;
  }    

  // todo: put all the getters

  public static Player parse(String line) {
    //todo: extract the data items from the string... 
  }

  @Override
  public String toString() {
    return String.format("%s (Time: %d Grid: %s) Score: %.4f", name, time, grid, score);
  }
}