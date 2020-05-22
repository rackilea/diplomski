import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main {

    public static void main(String[] args) {
        new Main();
    }

    public Main() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
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
            setLayout(new BorderLayout());

            JSplitPane pane = new JSplitPane();
            pane.setLeftComponent(makePane(Color.RED));
            pane.setRightComponent(makePane(Color.BLUE));

            Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
                @Override
                public void eventDispatched(AWTEvent event) {
                    if (event instanceof MouseEvent) {
                        MouseEvent me = (MouseEvent) event;
                        if (pane.getBounds().contains(me.getPoint())) {
                            System.out.println("Global Motion in the pane...");
                            me = SwingUtilities.convertMouseEvent(me.getComponent(), me, pane);
                            Component left = pane.getLeftComponent();
                            if (left.getBounds().contains(me.getPoint())) {
                                pane.setDividerLocation(100);
                            } else {
                                pane.setDividerLocation(20);
                            }
                        }
                    }
                }
            }, MouseEvent.MOUSE_MOTION_EVENT_MASK);

            // You don't need this, this is to demonstrate
            // that mouse events aren't hitting your component
            // via the listener
            pane.addMouseMotionListener(new MouseAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    System.out.println("Motion in the pane...");
                    Component left = pane.getLeftComponent();
                    if (left.getBounds().contains(e.getPoint())) {
                        pane.setDividerLocation(100);
                    } else {
                        pane.setDividerLocation(20);
                    }
                }

            });
            pane.setDividerLocation(20);

            add(pane);
        }

        protected JPanel makePane(Color background) {
            JPanel pane = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(100, 100);
                }
            };
            pane.setLayout(new GridBagLayout());
            pane.add(new JButton("..."));
            pane.setBackground(background);
            pane.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("...");
                }
            });
            return pane;
        }

    }

}