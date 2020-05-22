public class Model extends Observable {
    public void transform() {

       // Do the transformation

       // notify the view
       setChanged();
       notifyObservers();
    }
}