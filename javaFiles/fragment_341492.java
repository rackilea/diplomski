public class Player{

    private String name;
    private int score;        

    Player(String name){
        this.name = name;
    }

    public void setScore(int score){
        this.score = score;
    }

    public int getScore(){
        return score;
    }
}