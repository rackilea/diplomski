import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.URL;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class Sistem extends JFrame {

    public Sistem() {
        this.setTitle("Unknown man Unkown power");
        this.setFocusable(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(new Ngrep());
        this.setResizable(false);
        this.pack();

        this.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Sistem();
            }
        });
    }
}

@SuppressWarnings("serial")
class Ngrep extends JPanel {

    private int l = 375;
    private int t = 150;
    private BufferedImage bg;
    JLabel menu1 = new JLabel("MULAI BARU");
    JLabel menu2 = new JLabel("KELUARRR");

    public Ngrep() {
        this.add(menu1);
        this.add(menu2);

        try {
            Font f = new Font(Font.MONOSPACED, Font.ITALIC, 30);
            menu1.setFont(f);
            menu1.setForeground(Color.RED);
            menu2.setFont(f);
            menu2.setForeground(Color.RED);
            URL url = new URL("http://i.stack.imgur.com/OVOg3.jpg");
            bg = ImageIO.read(url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        setLayout(new GridLayout(2, 3));

        add(menu1);
        add(menu2);
    }

    public Dimension getPreferredSize() {
        return new Dimension(l, t);
    }

    /*
     * For a JComponent, override paintComponent rather than paint
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // a JPanel IS AN ImageObserver
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}