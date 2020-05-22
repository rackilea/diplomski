public class Snail {

    private double x;
    private double y;
    private SnailObserver observer;

    public void move() {
        // Move the snail and then notify the observer
        // that the snail has changed like so: 
        observer.update(this);
    }

    public void registerObserver(SnailObserver observer) {
        this.observer = observer;
        observer.update(this); // initial sync
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

}