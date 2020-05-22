public class TeamConfidence implements Comparable<TeamConfidence> {
  private String winner;
  private String loser;
  private double confidence;

  public TeamConfidence(String winner, String loser, double confidence) {
    this.winner = winner;
    this.loser = loser;
    this.confidence = confidence;
  }

  @Override
  public String toString() {
    return "(" + confidence + ", " + winner + ", " + loser ")";
  }

  @Override
  public int compareTo(TeamConfidence other) {
      if(other == this) { 
        return true;
      } else if (other == null ) {
        return false;
      } else {
        return Double.compare(confidence, other.confidence);
      }
  }
}