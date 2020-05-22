//a model representing ball
class Ball  {

    //Ball attributes
    private static final int SIZE = 10;  //diameter
    private int x, y;  // Position
    private final Color color;
    private Observer observer;  //to be notified on changes

    Ball() {

        Random rnd = new Random();
        color = new Color(rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }

    Color getColor() {
        return color;
    }

    int getSize(){
        return SIZE;
    }

    synchronized int getX() {
        return x;
    }

    synchronized void setX(int x) {
        this.x = x;
        notifyObserver();
    }

    synchronized int getY() {
        return y;
    }

    synchronized void setY(int y) {
        this.y = y;
        notifyObserver();
    }

    void registerObserver(Observer observer){
        this.observer = observer;
    }

    void notifyObserver(){
        if(observer == null) return;
        observer.onObservableChanged();
    }
}