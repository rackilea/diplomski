public class Team implements Comparable<Team> {
    private int points;
    private int goalDifference;

    public Team(int points, int goalDifference) {
        this.points = points;
        this.goalDifference = goalDifference;
    }

    @Override
    public int compareTo(Team other) {
        int res = other.points - this.points;
        return res != 0 ? res : (other.goalDifference - this.goalDifference);
    }

    //getters and setters
}