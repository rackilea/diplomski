public class ScoreStack {
    private class ScoreNode {
        int score;
        ScoreNode next;

        ScoreNode(int score, ScoreNode next) {
            this.score = score;
            this.next = next;
        }
    }

    private int score = 0;
    private ScoreNode root = null;

    public void push(int score) {
        root = new ScoreNode(score, root);
        this.score += score;
    }

    public int pop() {
        if (root == null) {
            return 0;
        }
        int score = root.score;
        root = root.next;
        this.score -= score;
        return score;
    }

    public void reset() {
        root = null;
    }

    @Override
    public String toString() {
        return String.valueOf(score);
    }
}