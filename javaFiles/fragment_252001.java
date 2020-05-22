import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class GloablMouseListener {

    public static void main(String[] args) {
        new GloablMouseListener();
    }

    public GloablMouseListener() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());
            JPanel panel = new JPanel();
            panel.setBackground(Color.BLUE);
            JTextArea ta = new JTextArea(10, 20);
            add(panel, BorderLayout.NORTH);
            add(new JScrollPane(ta), BorderLayout.SOUTH);

            Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
                @Override
                public void eventDispatched(AWTEvent event) {
                    if (event instanceof MouseEvent) {
                        MouseEvent e = (MouseEvent) event;
                        System.out.println("Local point = " + e.getPoint());
                        Point p = e.getPoint();
                        Window window = SwingUtilities.getWindowAncestor(e.getComponent());
                        if (window != e.getSource() && window != null) {
                            p = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(), window);
                        }
                        System.out.println("Global point = " + p);
                    }
                }
            }, AWTEvent.MOUSE_EVENT_MASK | AWTEvent.MOUSE_MOTION_EVENT_MASK);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }
    }
}