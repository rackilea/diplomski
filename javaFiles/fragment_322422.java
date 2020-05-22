import java.awt.AWTException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class BlurryFrame extends JFrame implements ActionListener, ComponentListener {

    public static void main(String... sss) {

        JLabel label1 = new JLabel("TestLabel 1");
        label1.setSize(500, 100);
        label1.setForeground(Color.RED);

        JLabel label2 = new JLabel("TestLabel 2");
        label2.setHorizontalAlignment(SwingConstants.CENTER);
        label2.setForeground(Color.BLUE);

        JPanel testPanel = new JPanel();
        testPanel.setOpaque(false);
        testPanel.setLayout(new BorderLayout());
        testPanel.add(label1, BorderLayout.CENTER);
        testPanel.add(label2, BorderLayout.SOUTH);

        BlurryFrame frame = new BlurryFrame(800, 600, testPanel);
        frame.setBackground(new Color(0, 0, 0, 100));
        frame.setVisible(true);
    }

    private final BackgroundPanel backgroundPane;
    private final JLayeredPane container;
    private final JPanel containerPane;
    private final Robot robot;

    // This rectangle is going to be your screenshots bounds to keep the image only as big as necessary
    private final Rectangle captureRect;

    // This is going to be the blurred screenshot
    private BufferedImage background;

    public BlurryFrame() {
        this(1280, 800);
    }

    public BlurryFrame(int width, int height) {
        this(width, height, null);
    }

    public BlurryFrame(int width, int height, JComponent component) {

        this.captureRect = new Rectangle();
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            throw new RuntimeException(e);
        }

        this.backgroundPane = new BackgroundPanel();
        this.backgroundPane.setOpaque(false);
        this.backgroundPane.setLayout(new BorderLayout());
        this.backgroundPane.setBounds(0, 0, width, height);
        this.backgroundPane.addComponentListener(this);

        this.containerPane = new JPanel();
        this.containerPane.setOpaque(false);
        this.containerPane.setLayout(new BorderLayout());
        this.containerPane.add(component, BorderLayout.CENTER);
        this.containerPane.setBounds(0, 0, width, height);

        this.setUndecorated(true);
        this.setSize(width, height);
        this.setLocationRelativeTo(null);

        this.container = new JLayeredPane();
        this.container.setOpaque(false);
        this.container.setLayout(new BorderLayout());
        this.container.add(this.backgroundPane, 1);
        this.container.add(this.containerPane, 0);

        this.getContentPane().add(this.container, BorderLayout.CENTER);
    }

    public void add(JComponent component) {
        this.containerPane.add(component, BorderLayout.CENTER);
        this.containerPane.repaint();
    }

    // This method does not really do much but ultimately triggers the screenshot by ending up in #componentHidden(...)
    private void capture() {
        this.containerPane.setVisible(false);
        this.backgroundPane.setVisible(false);
        this.repaint();
    }

    @Override
    public void setVisible(boolean visible) {

        super.setVisible(visible);
        this.capture();

        // XXX uncomment this if you want to see the flickering
        // Timer timer = new Timer(60, this);
        // timer.start();
    }

    @Override
    public void setSize(int width, int height) {

        super.setSize(width, height);

        this.captureRect.setSize(width, height);
        this.backgroundPane.setBounds(0, 0, width, height);
        this.containerPane.setBounds(0, 0, width, height);

        if (this.isVisible())
            this.capture();
    }

    @Override
    public void setSize(Dimension dimension) {

        super.setSize(dimension);

        this.captureRect.setSize(dimension);
        this.backgroundPane.setBounds(0, 0, dimension.width, dimension.height);
        this.containerPane.setBounds(0, 0, dimension.width, dimension.height);

        if (this.isVisible())
            this.capture();
    }

    @Override
    public void setPreferredSize(Dimension dimension) {

        super.setPreferredSize(dimension);

        this.captureRect.setSize(dimension);
        this.backgroundPane.setBounds(0, 0, dimension.width, dimension.height);
        this.containerPane.setBounds(0, 0, dimension.width, dimension.height);

        if (this.isVisible())
            this.capture();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.capture();
    }

    int i = 0;

    // This is where the magic happens. The capturing needs to be done here in order to assure the applications content has really been hidden
    @Override
    public void componentHidden(ComponentEvent e) {

        int x = this.getLocationOnScreen().x;
        int y = this.getLocationOnScreen().y;

        this.captureRect.setLocation(x, y);

        this.background = this.robot.createScreenCapture(this.captureRect);

        //XXX uncomment this if you want to see what gets captured
        //      if (this.i < 1) {
        //          try {
        //              ImageIO.write(this.background, "png", new File(System.getProperty("user.home") + "\\test.png"));
        //          } catch (IOException ex) {
        //              ex.printStackTrace();
        //          }
        //          this.i++;
        //      }

        this.containerPane.setVisible(true);
        this.backgroundPane.setVisible(true);
        this.repaint();
    }

    @Override
    public void componentMoved(ComponentEvent e) {
        this.capture();
    }

    @Override
    public void componentResized(ComponentEvent e) {
        this.capture();
    }

    private class BackgroundPanel extends JPanel {

        private final float[] matrix = {
                0.111f, 0.111f, 0.111f,
                0.111f, 0.111f, 0.111f,
                0.111f, 0.111f, 0.111f,
        };

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g);

            if (BlurryFrame.this.background != null) {

                BufferedImageOp op = new ConvolveOp(new Kernel(3, 3, this.matrix));
                BufferedImage blurryBack = op.filter(BlurryFrame.this.background, null);

                g.drawImage(blurryBack, 0, 0, null);
            }
        }
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }
}