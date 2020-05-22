import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class Panel extends JPanel {
    Color[] colors = {Color.WHITE, Color.BLUE, Color.RED, Color.YELLOW, Color.CYAN, Color.GREEN, Color.PINK, Color.ORANGE};

    Random r = new Random();

    int amount, actual;

    Color nextColor;

    int x1, y1, x2, y2;

    public Panel(int amount) {
        this.amount = amount;
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                nextColor = colors[r.nextInt(7)];
                x1 = r.nextInt(600);
                x2 = r.nextInt(600);
                y1 = r.nextInt(600);
                y2 = r.nextInt(600);
                repaint();
                if (++actual >= amount) {
                    Timer t = (Timer) evt.getSource();
                    t.stop();
                }
            }
        });
        timer.setRepeats(true);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        if (nextColor != null) {
            g.setColor(nextColor);
            g.drawLine(x1, y1, x2, y2);
        }

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frm = new JFrame("Lines");

                frm.add(new Panel(10));
                frm.setSize(700, 700);
                frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frm.setLocationRelativeTo(null);
                frm.setVisible(true);
            }
        });
    }
}