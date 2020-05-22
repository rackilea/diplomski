public class Score implements Comparable<Score> {
    private int pid;
    private int score;

    public Score(int pid, int score) {
        this.pid = pid;
        this.score = score;
    }

    public int compareTo(Score other) {
        return Integer.compare(this.score, other.score);
    }
}