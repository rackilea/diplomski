public final class Pig {

    private double x;
    private double y;
    private double velocityX;
    private double velocityY;
    private boolean jumpLock;

    public Pig() {
        // ...
    }

    public void timeChanged() {
        x += velocityX;
        y += velocityY; 
        velocityY -= Settings.GRAVITY;
    }

    public void jumpBoost() {
        if (!jumpLock) {
            velocityY = Settings.BOOST_VELOCITY;
            jumpLock = true;
        }
    }

    public void releaseLock() {
        jumpLock = false;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }