public class Score implements Serializable {
    private int wins;
    private int loses;
    private int gamesPlayed;
    //constructor, getter and setters...
}

public class ScoreDataHandler {

    private static final String fileName = "score.dat";
    public void saveScore(Score score) {
        ObjectOutputStreamout = null;
        try {
            out = new ObjectOutputStream(new FileOutputStream(fileName));
            out.writeObject(score);
        } catch (Exception e) {
            //handle your exceptions...
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException ioe) {
                }
            }
        }
    }

    public Score loadScore() {
        ObjectInputStreamin = null;
        Score score = null;
        try {
            in = new ObjectInputStream(new FileInputStream(fileName));
            score = (Score)in.readObject();
        } catch (Exception e) {
            //handle your exceptions...
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioe) {
                }
            }
        }
        return score;
    }
}