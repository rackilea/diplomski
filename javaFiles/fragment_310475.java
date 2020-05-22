import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UnsupportedLookAndFeelException;

public class TestFullScreen {

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException,
            UnsupportedLookAndFeelException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new TestFullScreen().initUI();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static class ImagePanel extends JPanel {
        private ImageIcon imageIcon;

        public ImagePanel(ImageIcon imageIcon) {
            super();
            this.imageIcon = imageIcon;
        };

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(imageIcon.getImage(), 0, 0, getWidth(), getHeight(), this);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight());
        }

    }

    protected void initUI() throws MalformedURLException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(new ImagePanel(new ImageIcon(new URL("http://blog.timesunion.com/opinion/files/2011/10/brickwall.jpg"))));
        frame.setUndecorated(true);
        frame.pack();
        frame.setExtendedState(frame.getExtendedState() & JFrame.MAXIMIZED_BOTH);
        // GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(frame);
        frame.setVisible(true);
    }

}