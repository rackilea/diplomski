public class ScoreEntry implements Comparable<ScoreEntry> {
    public final String name;
    public final int score;

    public ScoreEntry (String name, int score){
        this.name = name;
        this.score = score;
    }

    public int compareTo (ScoreEntry other){
        return Integer.signum(score - other.score);
    }
}