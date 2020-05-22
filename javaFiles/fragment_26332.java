public class TeamConfidence implements Comparable<TeamConfidence> {
  private String team;
  private double confidence;

  public TeamConfidence(String team, double confidence) {
    this.team = team;
    this.confidence = confidence;
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

  // include getters and setters, maybe a constructor
}