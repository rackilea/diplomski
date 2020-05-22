public class Enemy extends Quad{

    private EnemyType mType;

    //All other class members...

    // Constructor with type
    public Enemy(EnemyType type){
        this.mType = type;
    }

    public void doEnemyStuff(){
         if(isBird()){
         // Bird Stuff
         }
         else if(isSnail()){
         // Snail Stuff
         }
    }

    //Check if current enemy is a Bird
    public boolean isBird(){
        return mType == EnemyType.Bird;
    }

    //Check if current enemy is a Snail
    public boolean isSnail(){
        return mType == EnemyType.Snail;
    }
}