import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Birthday {

    DrawString panel = new DrawString();

    public Birthday() {
        JFrame f = new JFrame();

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(panel);
        f.setTitle("Happy Birthday!");
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);

        Timer timer = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.repaint();
            }
        });
        timer.start();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Birthday();
            }
        });
    }
}

class DrawString extends JPanel {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();

        int x = 350;
        int y = 250;
        int red = random(0, 255);
        int green = random(0, 255);
        int blue = random(0, 255);
        Color black = new Color(0, 0, 0);

        Color newColor = new Color(red, green, blue);
        g.setColor(newColor);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(black);
        g.setFont(new Font(null, Font.BOLD, 40));
        g.drawString("Happy Birthday!", x, y);
    }

    public static int random(int min, int max) {
        int range = max - min + 1;
        int number = (int) (range * Math.random() + min);
        return number;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 500);
    }
}