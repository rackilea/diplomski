public class Player {

    private String name ;
    private int[] scores ;
    private int total ;

    public Player(String name) {
        this.name = name ;
        this.scores = new int[11] ; // all initialized to zero, as is total.
    }

    public void setScore(int whichScore, int score) {
        int change = score - scores[whichScore] ;
        scores[whichScore] = score ;
        total = total + change ;
    }


    public int getScore(int whichScore) {
        return scores[whichScore] ;
    }

    public int getTotal() {
        return total ;
    }

    public String getName() {
        return name ;
    }

    public void setName(String name) {
        this.name = name ;
    }
}