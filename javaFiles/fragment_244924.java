import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.LinearGradientPaint;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

public class FullScreenBackground {

    public static void main(String[] args) {
        new FullScreenBackground();
    }

    public FullScreenBackground() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

                JFrame frame = new JFrame("Testing");
                frame.setAlwaysOnTop(true);
                frame.setUndecorated(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new BackgroundPane());
                frame.setLocation(0, 0);
                frame.setSize(dim);
                frame.setVisible(true);

                JDialog dialog = new JDialog(frame);
                dialog.setContentPane(new InstallPane());
                dialog.pack();
                dialog.setLocationRelativeTo(frame);
                dialog.setVisible(true);
            }
        });
    }

    public class InstallPane extends JPanel {

        public InstallPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(new JLabel("<html><h1>Welcome to my fancy pancy background screen<h1></html>"), gbc);
        }

    }

    public class BackgroundPane extends JPanel {

        private BufferedImage bg;

        public BackgroundPane() {
        }

        @Override
        public void invalidate() {
            super.invalidate(); 
            bg = null;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (bg == null) {
                bg = new BufferedImage(1, getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D g2d = bg.createGraphics();
                LinearGradientPaint lgp = new LinearGradientPaint(
                                new Point(0, 0),
                                new Point(0, getHeight()),
                                new float[]{0f, 1f},
                                new Color[]{Color.BLACK, Color.BLUE}
                );
                g2d.setPaint(lgp);
                g2d.fillRect(0, 0, 1, getHeight());
            }
            g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
        }

    }

}