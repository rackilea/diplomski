import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Something extends JPanel {

    static final int CANVAS_WIDTH = 400;
    static final int CANVAS_HEIGHT = 100;
    private int xDelta = 0;

public Something(){
    ActionListener animater = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            repaint();
        }
    };
    Timer t = new Timer(10,animater);
    t.start();
}


@Override
public void paintComponent(Graphics g){
    super.paintComponent(g);
    g.setColor(Color.cyan);
    g.fillRect(0, 0, getWidth()-(xDelta--), getHeight()-100);
    g.setColor(Color.BLACK);
    g.fillOval(xDelta, 10, 25, 25);

    if (xDelta<0) {
        xDelta = CANVAS_WIDTH;
    }
}

@Override
public Dimension getPreferredSize() {
    return new Dimension(CANVAS_WIDTH, CANVAS_HEIGHT);
}

public static void main(String[] args) {

    JFrame frame = new JFrame();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel p = new JPanel(new GridLayout());

    frame.getContentPane().add(p);
    Something s = new Something();

    p.add(s);
    p.setBackground(Color.black);
    frame.pack();
    frame.setResizable(false);
    frame.setVisible(true);
}
}