public class Particle{
    private int x;
    private int y;
    private int width;
    private int height;
    private float mass;
    //
    public Particle() {
        //...
    }

    public boolean collide(Particle other){
        return Math.abs(this.x-other.x) < width 
                && Math.abs(this.y-other.y) < height; // Just to illustrate the idea 
    }
}