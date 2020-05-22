import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class TranslucentPanelExample {

    public static void main(String[] args) {
        new TranslucentPanelExample();
    }

    public TranslucentPanelExample() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    JLabel background = new JLabel(
                            new ImageIcon(ImageIO.read(
                                            getClass().getResource("/background.jpg"))));
                    background.setLayout(new GridBagLayout());
                    background.add(new WaitPane());

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(background);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

    public class WaitPane extends JPanel {

        public WaitPane() {
            setLayout(new GridBagLayout());
            setBorder(new EmptyBorder(12, 12, 12, 12));
            // This is very important
            setOpaque(false);
            setBackground(new Color(0, 0, 0, 150));

            String loadLink = "http://i.imgur.com/mHm6LYH.gif";
            URL ajaxLoad = null;
            try {
                ajaxLoad = new URL(loadLink);
            } catch (MalformedURLException e3) {
                // TODO Auto-generated catch block
                e3.printStackTrace();
            }

            ImageIcon loading = new ImageIcon(ajaxLoad);
            JLabel loadBar = new JLabel(loading);
            loadBar.setHorizontalAlignment(JLabel.CENTER);
            loadBar.setVerticalAlignment(JLabel.CENTER);
            add(loadBar);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }

    }

}