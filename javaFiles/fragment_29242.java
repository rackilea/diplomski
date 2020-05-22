import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class CantCatchMe extends JApplet {

    Window window;
    Dimension screenSize;
    JPanel gui;
    Random r = new Random();

    public void init() {
        ActionListener al = new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                moveAppletViewer();
            }
        };
        gui = new JPanel();
        gui.setBackground(Color.YELLOW);
        add(gui);

        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        // change 2000 (every 2 secs.) to 200 (5 times a second) for REALLY irritating!
        Timer timer = new Timer(2000, al);
        timer.start();
    }

    public void start() {
        Container c = gui.getParent();
        while (c.getParent()!=null) {
            c = c.getParent();
        }
        if (c instanceof Window) {
            window = (Window)c;
        } else {
            System.out.println(c);
        }
    }

    private void moveAppletViewer() {
        if (window!=null) {
            int x = r.nextInt((int)screenSize.getWidth());
            int y = r.nextInt((int)screenSize.getHeight());
            window.setLocation(x,y);
        }
    }
}