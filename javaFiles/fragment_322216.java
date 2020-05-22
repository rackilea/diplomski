import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Test extends JPanel {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame f = new JFrame();
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                f.setSize(300, 400);
                Test view = new Test();

                view.setBorder(BorderFactory.createLineBorder(Color.BLUE));
                JScrollPane comp = new JScrollPane();
                ViewPortDirection vp = new ViewPortDirection();
                comp.setViewport(vp);
                comp.setViewportView(view);
                comp.setBorder(BorderFactory.createLineBorder(Color.RED));
                f.getContentPane().add(comp, BorderLayout.CENTER);
                f.setVisible(true);
            }
        });
    }

    public static class ViewPortDirection extends JViewport {

        private BufferedImage i;
        private Random r = new Random();

        public ViewPortDirection() {
            try {
                i = ImageIO.read(new URL("https://cdn4.iconfinder.com/data/icons/cc_mono_icon_set/blacks/48x48/br_next.png"));
                new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        repaint();
                    }
                }).start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    repaint(0, 0, i.getWidth(), i.getHeight());
                }
            });
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            Graphics2D g2d = (Graphics2D) g.create();
            AffineTransform transform = AffineTransform.getRotateInstance(r.nextFloat() * Math.PI * 2, i.getWidth() / 2, i.getHeight() / 2);

            int x = 0;
            int y = 0;
            g2d.setTransform(transform);
            g2d.drawImage(i, x, y, this);
            g2d.dispose();
        }

    }

    public Test() {
        setBackground(Color.BLUE);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(1000, 1000);
    }

}