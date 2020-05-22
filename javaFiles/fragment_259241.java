import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Background extends JFrame {

    private Random ran;
    private int value;
    private JButton r;
    private JButton c;

    public Background() {
        super("title");
        ran = new Random();
        value = nextValue();
        setLayout(new FlowLayout());

        r = new JButton("ROLL ");
        r.setForeground(Color.WHITE);//ndryshon ngjyren e shkrimit
        r.setBackground(Color.YELLOW);
        add(r);

        try {
            BufferedImage die = ImageIO.read(getClass().getResource("1.png"));
            c = new JButton(new ImageIcon(die));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        add(c);

        thehandler hand = new thehandler(this);//konstruktori i handler merr nje instance te Background
        r.addActionListener(hand);
        c.addActionListener(hand);
    }

    private int nextValue() {
        return Math.abs(ran.nextInt()) % 6 + 1;
    }

    public void roll() {
        value = nextValue();
        c.setText(Integer.toString(value));
        URL path = null;
        if (value == 1) {
            path = getClass().getResource("1.png");
        } else if (value == 2) {
            path = getClass().getResource("2.png");
        }
        try {
            BufferedImage die = ImageIO.read(path);
            c.setIcon(new ImageIcon(die));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public int getValue() {
        return value;
    }

    private class thehandler implements ActionListener {

        private Background m;

        thehandler(Background thisone) {
            m = thisone;
        }

        public void actionPerformed(ActionEvent event) {
            m.roll();
        }
    }

    public static void main(String[] args) {
        Background d = new Background();
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        d.getContentPane().setBackground(Color.GREEN);
        d.setSize(700, 500);
        d.setVisible(true);
    }
}