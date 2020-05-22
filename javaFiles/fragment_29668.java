import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

public class JInternalFrameDemo {

    private JDesktopPane jdpDesktop;
    private static int openFrameCount = 0;
    private BufferedImage img;

    public JInternalFrameDemo() {
        JFrame frame = new JFrame("JInternalFrame Usage Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            img = ImageIO.read(new URL("http://images1.wikia.nocookie.net/__cb20120817224359/villains/images/6/6a/Nine-Tailed_Fox_(Naruto).jpg"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // A specialized layered pane to be used with JInternalFrames
        jdpDesktop = new JDesktopPane() {
            @Override
            protected void paintComponent(Graphics grphcs) {
                super.paintComponent(grphcs);
                grphcs.drawImage(img, 0, 0, null);
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(img.getWidth(), img.getHeight());
            }
        };



        createFrame(); // Create first window

        frame.setContentPane(jdpDesktop);

        frame.setJMenuBar(createMenuBar());

        // Make dragging faster by setting drag mode to Outline
        jdpDesktop.putClientProperty("JDesktopPane.dragMode", "outline");

        frame.pack();
        frame.setVisible(true);
    }

    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Frame");
        menu.setMnemonic(KeyEvent.VK_N);
        JMenuItem menuItem = new JMenuItem("New IFrame");
        menuItem.setMnemonic(KeyEvent.VK_N);
        menuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createFrame();
            }
        });
        menu.add(menuItem);
        menuBar.add(menu);
        return menuBar;
    }

    protected void createFrame() {
        MyInternalFrame frame = new MyInternalFrame();
        frame.setVisible(true);
        // Every JInternalFrame must be added to content pane using JDesktopPane
        jdpDesktop.add(frame);
        try {
            frame.setSelected(true);
        } catch (java.beans.PropertyVetoException e) {
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JInternalFrameDemo();
            }
        });
    }

    class MyInternalFrame extends JInternalFrame {

        static final int xPosition = 30, yPosition = 30;

        public MyInternalFrame() {
            super("IFrame #" + (++openFrameCount), true, // resizable
                    true, // closable
                    true, // maximizable
                    true);// iconifiable
            setSize(300, 300);
            // Set the window's location.
            setLocation(xPosition * openFrameCount, yPosition
                    * openFrameCount);
        }
    }
}