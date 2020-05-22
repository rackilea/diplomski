public class ScoreEntry implements Comparable<ScoreEntry> {
    public final String name;
    public final int score;
    public final long time;

    public ScoreEntry (String name, int score, long time){
        this.name = name;
        this.score = score;
        this.time = time;
    }

    public int compareTo (ScoreEntry other){
        if (score == other.score)
            return Long.signum(other.time - time);
        return Integer.signum(score - other.score);
    }
}