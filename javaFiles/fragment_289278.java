//the textfield is wrapped in a class so that it can extends Observable
public class MyTextField extends Observable {

    private JTextField jTextField = new JTextField();

    //this method notifies the observers you will add   
    public void notify(Object o) {
        this.setChanged();
        this.notifyObservers(o);
    }

    public JTextField getJTextField() {
        return jTextField;
    }

}

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

// The main class that observes the swing component you tell it to
public class Controller implements Observer {

    private final JFrame jFrame = new JFrame();

    private final MyTextField myTextField = new MyTextField();

    public Controller() {

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
        jFrame.add(myTextField.getJTextField());

        //here we add the Observer (Controller) to myTextField (Observable)
        myTextField.addObserver(this);

        //and the keylistener
        myTextField.getJTextField().addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println("keyTyped " + e.getKeyCode());
                //now we notify our observers for real
                myTextField.notify(e.getKeyCode());
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println("keyReleased " + e.getKeyCode());
                myTextField.notify(e.getKeyCode());
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("keyPressed " + e.getKeyCode());
                myTextField.notify(e.getKeyCode());
            }
        });
    }

    // this is where the event is received by the Observer 
    // from the observable.
    @Override
    public void update(Observable observable, Object object) {
        System.out.println("Notified by " + observable
                + " with object " + object);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Controller();
            }
        });
    }
}