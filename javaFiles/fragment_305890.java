import java.util.Observable;          //Observable is here

public class Planet extends Observable implements Runnable {
    public void run() {
        try {
            while (true) {
                //do planet stuff
                setChanged();
                notifyObservers(response);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}


import java.util.Observable;
import java.util.Observer;  /* this is Event Handler */

public class Moon implements Observer {
    //setup moon instance
    public void update(Observable obj, Object arg) {
       //udate moon params
    }
}

//
public class GameApp {
    public static void main(String[] args) {
        //configure game board...

        final Planet earth = new Planet();
        final Planet saturn = new Planet();

        // create an observer
        final Moon moon = new Moon();

        final Moon tethys = new Moon();
        final Moon titan = new Moon();

        // subscribe the observer to the event source
        earth.addObserver(moon);

        saturn.addObserver(tethys);
        saturn.addObserver(titan);

        // fire up the game ... 
    }
}