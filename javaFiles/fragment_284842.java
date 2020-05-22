import java.awt.*;
import static java.awt.GraphicsDevice.WindowTranslucency.*;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class JFrameSizeAfterDrag2 extends JFrame {

    private Timer timer;
    private JPanel panel2;
    boolean canResize = true,firstTime = true;


    public JFrameSizeAfterDrag2() {
        super("GradientTranslucentWindow");

        setBackground(new Color(0, 0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setContentPane(new JPanel(null) {//contentpane layout is null only
            @Override
            protected void paintComponent(Graphics g) {
                Paint p = new GradientPaint(0.0f, 0.0f, new Color(0, 0, 0, 0), 0.0f, getHeight(), new Color(0, 0, 0, 0), true);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setPaint(p);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(300, 300);
            }
        });

        panel2 = new JPanel();
        panel2.setBackground(Color.black);
        getContentPane().add(panel2);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent me) {
                super.mouseReleased(me);
                if (canResize) {
                    resizePanel(getContentPane().getSize());
                }
            }
        });

        addComponentListener(new ComponentAdapter() {

            @Override
            public void componentResized(ComponentEvent e) {
                timer = new Timer(50, new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (timer.isRunning()) {
                            canResize = false;
                        } else {
                            canResize = true;
                            if (firstTime == true) {
                                firstTime = false;
                                resizePanel(getContentPane().getSize());
                            }
                        }
                    }
                });
                timer.setRepeats(false);
                timer.start();

            }
        });
        pack();
    }

    public void resizePanel(Dimension dim) {
        panel2.setBounds(0, 0, dim.width, dim.height);
        revalidate();
    }

    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gd = ge.getDefaultScreenDevice();
        boolean isPerPixelTranslucencySupported = gd.isWindowTranslucencySupported(PERPIXEL_TRANSLUCENT);

        if (!isPerPixelTranslucencySupported) {
            System.out.println("Per-pixel translucency is not supported");
            System.exit(0);
        }

        JFrame.setDefaultLookAndFeelDecorated(true);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrameSizeAfterDrag2 gtw = new JFrameSizeAfterDrag2();
                gtw.setVisible(true);
            }
        });
    }
}