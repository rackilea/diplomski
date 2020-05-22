import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.lang.reflect.Method;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.LineBorder;

public class TransparentWindow02 {

    public static void main(String[] args) {
        new TransparentWindow02();
    }

    public TransparentWindow02() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setUndecorated(true);
                setOpaque(frame, false);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setOpaque(false);
            setLayout(new BorderLayout());
            setBorder(new LineBorder(Color.RED));
            JLabel label = new JLabel("Click me if you can see me");
            label.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    SwingUtilities.windowForComponent(TestPane.this).dispose();
                }
            });
            add(label);
        }

    }

    public static void setOpaque(Window window, boolean opaque) {

        String version = System.getProperty("java.runtime.version");
        if (version.startsWith("1.7")) {
            window.setBackground(new Color(0, 0, 0, 0));
        } else {
            try {
                Class<?> awtUtilsClass = Class.forName("com.sun.awt.AWTUtilities");
                if (awtUtilsClass != null) {

                    Method method = awtUtilsClass.getMethod("setWindowOpaque", Window.class, boolean.class);
                    method.invoke(null, window, opaque);

                }
            } catch (Exception exp) {
                exp.printStackTrace();
            }
        }
    }
}