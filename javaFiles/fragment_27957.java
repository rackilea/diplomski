public class Bullet {
    private Direction direction;
    private float speed = 1.2f;
    private int x;
    private int y;

    public Bullet(int x, int y){
         this.x =x;
         this.y=y;        
    }

    public void launchBullet(Direction direction){
        this.direction=direction;
    }

    public void moveInDirection() {
        //move the bullet with speed in the set direction. Same as you already have but without the while loop.
    }
}