public class Score {

    public Score() {
        this(0,0,0);
    }

    public Score(int x) {
        this(x,0,0);
    }

    public Score(int x,int y){
        this(x,y,0);
    }

    public Score(int x,int y,int z) {
       Score(x,y,z); // Not sure what's this - you can't do a recursive constructor call. Doesn't make any sense
       return String.format("%d/%d%d",x,y,z); // Remove the return statment.
    }
}