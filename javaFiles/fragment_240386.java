public class DynamicObject {    
    protected float speed;

    public DynamicObject(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
       return this.speed;
    }
}

public class Player extends DynamicObject {
   /*some code*/
   public Player(float speed) {
       super(speed);
   }

}


public class Enemy extends DynamicObject {
       /*some code*/
   public Enemy(float speed) {
       super(speed);
   }
}