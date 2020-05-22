import java.awt.event.*;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class Reveal extends JPanel {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                new Reveal("Test", 5);
            }
        });
    }

    private JPanel panel = new JPanel();       //a panel to house the label
    private JLabel label = new JLabel();       //a label to house the image
    private ImageIcon[] icon = new ImageIcon[7]; //an array of icons to be the images
    private JFrame f;

    private TextOverlay TO;

    private Timer timer;
    private Timer timer2;
    int x = 0;
    int y = 4;
    int counter = 0;

    /**
     * Constructor for objects of class Reveal
     */
    public Reveal(String name, int number) {
        TO = new TextOverlay("Jack in the Box 7.png", name, number);

        for (int h = 0; h < 7; h++) {
            icon[h] = new ImageIcon(makeImage(h));
            icon[h].getImage();
        }

        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

        //Sets the size of the window
        f.setSize(800, 850);
        panel = new JPanel(new GridBagLayout());
        label = new JLabel();
        label.setIcon(icon[x]);
        label.setBorder(new LineBorder(Color.RED));
        panel.add(label);

        f.add(panel);
        display(name, number);
//      f.add(TO);

        setVisible(true);
    }

    public void display(String name, int number) {
        timer = new Timer(150, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (counter > 27) {
                    timer.stop();
                    timer2.start(); //starts the second half of the animation
                } else {

                    if (x != 3) {
                        x++;
                    } else {
                        x = 0;
                    }
                    label.setIcon(icon[x]);
                    counter++;
                } //ends if-else
            } //ends action method
        }); //ends timer

        timer2 = new Timer(250, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (y > 6) {
                    timer2.stop();
                    Container parent = label.getParent();
                    parent.remove(label);
                    parent.add(TO);
                    parent.revalidate();
                } else {
                    label.setIcon(icon[y]);
                    y++;
                } //ends if-else
            } //ends action method
        }); //ends timer2

        timer.start();
    }

    protected BufferedImage makeImage(int h) {
        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = img.createGraphics();
        FontMetrics fm = g2d.getFontMetrics();
        String text = Integer.toString(h);
        int x = (100 - fm.stringWidth(text)) / 2;
        int y = ((100 - fm.getHeight()) / 2) + fm.getAscent();
        g2d.setColor(Color.BLUE);
        g2d.fillRect(0, 0, 100, 100);
        g2d.setColor(Color.BLACK);
        g2d.drawString(text, x, y);
        g2d.dispose();
        return img;
    }

    public class TextOverlay extends JPanel {

        private BufferedImage image;
        private String name;
        private String fileX;
        private int number;

        public TextOverlay(String f, String s, int n) {
            name = s;
            number = n;
            fileX = f;

            image = makeImage(n);

            image = process(image, name, number);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

        private BufferedImage process(BufferedImage old, String name, int number) {
            int w = old.getWidth();
            int h = old.getHeight();
            BufferedImage img = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            g2d.drawImage(old, 0, 0, w, h, this);
            g2d.setPaint(Color.black);
            g2d.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 30));
            String s1 = name;
            String s2 = Integer.toString(number);;
            FontMetrics fm = g2d.getFontMetrics();
            g2d.drawString(s1, 40, 90);
            g2d.drawString(s2, 40, 140);
            g2d.dispose();
            return img;
        }
    }

}