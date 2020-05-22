/** Your domain class */
public class PasswordWithScore {
    private final String password;
    private final double score;

    public PasswordWithScore(String password) {
        this.password = password;
        this.score = findScore(password);
    }

    public String getPassword() { return password; }
    public double getScore() { return score; }

    @Override public String toString() {
        return password + ":" + score;
    }

    private static double findScore(String password) {
        // but different
        return password.chars().sum();
    }
}