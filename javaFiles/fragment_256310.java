import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

public class FullScreen {

    private static final long serialVersionUID = 1L;
    private GraphicsDevice device;
    private JButton button = new JButton("Close Meeee");
    private JPanel myPanel = new JPanel();
    private JFrame frame = new JFrame();
    private JLabel imageLabel;
    private Dimension halfScreenSize;
    private Random random;
    private JProgressBar memory;
    private Dimension d;
    private Font bigFont = new Font("Arial", Font.BOLD, 30);
    private int count = 0;
    private int startMem = 0;
    private int maxMem = 0;
    private int peakMem = 0;
    private int useMem = 0;
    private javax.swing.Timer timer = null;

    public FullScreen() {
        startMem = ((int) Runtime.getRuntime().freeMemory());
        maxMem = ((int) Runtime.getRuntime().freeMemory());
        peakMem = ((int) Runtime.getRuntime().freeMemory());
        d = Toolkit.getDefaultToolkit().getScreenSize();
        halfScreenSize = new Dimension(d.width, d.height);
        //halfScreenSize = new Dimension(d.width - 11, d.height - 51);
        random = new Random();
        imageLabel = new JLabel(new ImageIcon(convertToFromBytes(getImage())));
        memory = new JProgressBar(0, (int) Runtime.getRuntime().maxMemory());
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        myPanel.setLayout(new BorderLayout(10, 10));
        myPanel.add(imageLabel, BorderLayout.CENTER);
        myPanel.setFocusable(true);
        myPanel.add(button, BorderLayout.NORTH);
        myPanel.add(memory, BorderLayout.SOUTH);
        frame.add(myPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke("ENTER"), "clickENTER");
        frame.getRootPane().getActionMap().put("clickENTER", new AbstractAction() {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                exitFullScreen();
            }
        });
        enterFullScreen();
        frame.setVisible(true);
        Runnable doRun = new Runnable() {
            @Override
            public void run() {
                System.out.println(frame.getBounds());
            }
        };
        SwingUtilities.invokeLater(doRun);
        Runnable r = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        d = Toolkit.getDefaultToolkit().getScreenSize();
                        halfScreenSize = new Dimension(d.width, d.height);
                        imageLabel.setIcon(new ImageIcon(convertToFromBytes(getImage())));
                        memory.setValue((int) Runtime.getRuntime().freeMemory());
                        memory.setStringPainted(true);
                        useMem = ((int) Runtime.getRuntime().freeMemory());
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        //something with exception
                    } finally {
                        //alive that if required
                    }
                }
            }
        };
        Thread t = new Thread(r);
        t.start();
    }

    private void enterFullScreen() {
        GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        device = graphicsEnvironment.getDefaultScreenDevice();
        if (device.isFullScreenSupported()) {
            device.setFullScreenWindow(frame);
            frame.validate();
        }
    }

    private void exitFullScreen() {
        startOne();
    }

    private void startOne() {
        timer = new javax.swing.Timer(70, setFullScreenWindowFalse());
        timer.start();
        timer.setRepeats(false);
    }

    public Action setFullScreenWindowFalse() {
        return new AbstractAction("setFullScreenWindowFalse") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                device.setFullScreenWindow(null);
                startTwo();
            }
        };
    }

    private void startTwo() {
        timer = new javax.swing.Timer(70, hideJFrame());
        timer.start();
        timer.setRepeats(false);
    }

    public Action hideJFrame() {
        return new AbstractAction("hideJFrame") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                startThree();
            }
        };
    }

    private void startThree() {
        timer = new javax.swing.Timer(250, showJFrame());
        timer.start();
        timer.setRepeats(false);
    }

    public Action showJFrame() {
        return new AbstractAction("showJFrame") {
            private static final long serialVersionUID = 1L;

            @Override
            public void actionPerformed(ActionEvent e) {
                myPanel.setPreferredSize(new Dimension(400, 300));
                frame.pack();
                frame.setVisible(true);
            }
        };
    }

    private BufferedImage getImage() {
        GradientPaint gp = new GradientPaint(0f, 0f, new Color(127 + random.nextInt(128), 127 + random.nextInt(128), 127 + random.nextInt(128)),
                (float) halfScreenSize.width, (float) halfScreenSize.width, new Color(random.nextInt(128), random.nextInt(128), random.nextInt(128)));
        BufferedImage bi = new BufferedImage(halfScreenSize.width, halfScreenSize.height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bi.createGraphics();
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, halfScreenSize.width, halfScreenSize.height);
        g2d.setFont(bigFont);
        g2d.setColor(Color.BLACK);
        if (maxMem < ((int) Runtime.getRuntime().freeMemory())) {
            maxMem = ((int) Runtime.getRuntime().freeMemory());
        }
        if (peakMem > ((int) Runtime.getRuntime().freeMemory())) {
            peakMem = ((int) Runtime.getRuntime().freeMemory());
        }
        useMem = ((int) Runtime.getRuntime().freeMemory()) - useMem;
        g2d.drawString("" + ++count, 20, 100);
        g2d.drawString("JVM memory status --->  ", 20, 195);
        g2d.drawString("tot. memory --->  " + ((int) Runtime.getRuntime().totalMemory()), 20, 240);
        g2d.drawString("max. memory --->  " + ((int) Runtime.getRuntime().maxMemory()), 20, 270);
        g2d.drawString("free on startUp --->  " + startMem, 20, 300);
        g2d.drawString("max free memory --->  " + maxMem, 20, 350);
        g2d.drawString("min free memory --->  " + peakMem, 20, 380);
        g2d.drawString("act free memory --->  " + ((int) Runtime.getRuntime().freeMemory()), 20, 410);
        g2d.drawString("usage of memory --->  " + useMem, 20, 450);
        return bi;
    }

    private Image convertToFromBytes(BufferedImage image) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(image, "png", baos);
            return Toolkit.getDefaultToolkit().createImage(baos.toByteArray());
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Runnable doRun = new Runnable() {
            @Override
            public void run() {
                FullScreen fullScreen = new FullScreen();
            }
        };
        SwingUtilities.invokeLater(doRun);
    }
}