import java.awt.*;
import java.awt.event.*;

public class Finestra extends Frame implements WindowListener {

Finestra(){
    addWindowListener(this);

    setSize(400,400);
    setLayout(null);
    setVisible(true);
}
public void windowClosing(WindowEvent e) {
    System.out.println("closing");
    e.getWindow().dispose();
}

public void windowClosed(WindowEvent e) {
    System.exit(0);
}

public void windowOpened(WindowEvent e) {
    System.out.println("hello");
}

public void windowIconified(WindowEvent e) {
}

public void windowDeiconified(WindowEvent e) {
}

public void windowActivated(WindowEvent e) {
}

public void windowDeactivated(WindowEvent e) {
}