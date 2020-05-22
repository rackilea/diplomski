import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class SimpleDrawing extends JFrame {

public SimpleDrawing() {

    setSize(new Dimension(500, 500));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}

public void paint(Graphics g) {

    g.setColor(Color.red);
    g.fillOval(20, 50, 100, 100);
    g.setColor(Color.blue);
    g.fillRect(100, 100, 100, 200);
}

public static void main(String arg[]) {

    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
            new SimpleDrawing();
        }
    });
}

}