import java.util.Observable;
import java.util.Observer;


public class Main implements Observer {
    private DoSomething businessClass;

    public Main() {
        businessClass = new DoSomething();
        businessClass.addObserver(this);
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

    @Override
    public void update(Observable obs, Object obj) {
        // Do whatever you want to do with textarea or other UI components
    }
}

class DoSomething extends Observable {
    public DoSomething() {
        Object result = new Object();    // It can be any type not just an object
        // After finish...
        setChanged();
        notifyObservers(result);
    }
}