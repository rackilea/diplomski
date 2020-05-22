import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Main extends JFrame {

    Image dbImage;

    int GWIDTH = 800;
    int GHEIGHT = 500;

    public Main() {
        dbImage = new ImageIcon(getClass().getResource("/resources/stackoverflow5.png")).getImage();
        this.setTitle("Pond");
        add(new ImagePanel());
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setBackground(Color.cyan);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                Main m = new Main();
            }
        });
    }

    public class ImagePanel extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawImage(dbImage, 0, 0, GWIDTH, GHEIGHT, this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(GWIDTH, GHEIGHT);
        }
    }
}