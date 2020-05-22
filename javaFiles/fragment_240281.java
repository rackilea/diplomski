import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageTest {

    public static void main(String[] args) {
        ImagePanel panel = new ImagePanel("program/assets/main_bg.jpg");

        TopTabButton buttonHome = new TopTabButton("home");
        TopTabButton buttonSettings = new TopTabButton("settings");
        TopTabButton buttonHelp = new TopTabButton("help");

        panel.add(buttonHome);
        panel.add(buttonSettings);
        panel.add(buttonHelp);


//        panel.setPreferredSize(new Dimension(1000, 760));

        JFrame frame = new JFrame();
        frame.setBackground(new Color(53, 56, 64));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel, BorderLayout.NORTH);

        frame.pack();

        frame.setLocationRelativeTo(null);
//        frame.setResizable(false);
        frame.setVisible(true);
    }

    class TopTabButton extends JButton {

        public TopTabButton(String buttonCode) {
            setText(buttonCode);
//        setIcon(new ImageIcon("program/assets/top_tab_button_bg_" + buttonCode + "_inactive.png"));
//        setRolloverIcon(new ImageIcon("program/assets/top_tab_button_bg_" + buttonCode + "_active.png"));
//        setBorderPainted(false);
//        setFocusPainted(false);
//        setContentAreaFilled(true);
//        setSize(new Dimension(126, 75));
        }
    }

    class ImagePanel extends JPanel {

        private Image img;

        public ImagePanel(String img) {
            this(Toolkit.getDefaultToolkit().createImage(img));
        }

        public ImagePanel(Image img) {
            this.img = img;
            Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
//        setPreferredSize(size);
//        setMinimumSize(size);
//        setMaximumSize(size);
//        setSize(size);
            setLayout(new GridBagLayout());
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
        }
    }
//
//class ButtonPanelTest extends JPanel {
//
//    private Image img;
//
//    public ButtonPanelTest(String name) {
//        Button Button1 = new Button(name);
//        Dimension size = new Dimension(100, 50);
//        setSize(size);
//        setLayout(new GridBagLayout());
//    }
//}
}