import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog.ModalityType;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class TestSnipit {

    private static void createAndShowGui() {
        boolean runTest = true;

        if (runTest) {
            TestingPanel.main(null);
        } else {
            SnipIt.main(null);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

class TestingPanel {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TestingPanel window = new TestingPanel();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public TestingPanel() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 200, 160);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton btnSnip = new JButton("Snip");
        btnSnip.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                getSelectionSize();
            }
        });
        btnSnip.setBounds(47, 87, 89, 23);
        frame.getContentPane().add(btnSnip);
    }

    private void getSelectionSize() {
        int[] size = new int[4];

        // !!
        SnipIt sn = new SnipIt();
        sn.snip(frame);

        // Thread worker = new Thread(new Runnable() {
        // public void run() {
        // SnipIt sn = new SnipIt();
        // sn.snip();
        //
        // while (!sn.complete) {
        // try {
        // Thread.sleep(800);
        // } catch (InterruptedException e) {
        // e.printStackTrace();
        // }
        // }
        //

        size[0] = sn.returnSize()[0];
        size[1] = sn.returnSize()[1];
        size[2] = sn.returnSize()[2];
        size[3] = sn.returnSize()[3];

        // }
        // });
        //
        // worker.start();
        //
        // try {
        // worker.join();
        // } catch (InterruptedException e1) {
        // e1.printStackTrace();
        // }

        System.out.println(size[0] + " " + size[1] + " " + size[2] + " " + size[3]);
    }
}

class SnipIt {

    private int recX = 0;
    private int recY = 0;
    private int recWidth = 0;
    private int recHeight = 0;
    public boolean complete = false;

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                SnipIt s = new SnipIt();
                s.snip(null); // !!
            }
        });
    }

    public void snip(Window owner) { // !!
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
        }

        // JFrame frame = new JFrame();
        JDialog frame = new JDialog(owner, null, ModalityType.APPLICATION_MODAL); // !!
        frame.setUndecorated(true);
        frame.setBackground(new Color(0, 0, 0, 0));
        // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); // !!
        frame.setLayout(new BorderLayout());
        frame.add(new SnipItPane());
        frame.setBounds(getVirtualBounds());
        frame.setVisible(true);
    }

    @SuppressWarnings("serial")
    public class SnipItPane extends JPanel {

        private Point mouseAnchor;
        private Point dragPoint;

        private SelectionPane selectionPane;
        private ControlPane controlPane;

        public SnipItPane() {
            setOpaque(false);
            setLayout(null);
            selectionPane = new SelectionPane();
            controlPane = new ControlPane();
            add(selectionPane);
            add(controlPane);
            MouseAdapter adapter = new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    mouseAnchor = e.getPoint();
                    dragPoint = null;
                    selectionPane.setLocation(mouseAnchor);
                    selectionPane.setSize(0, 0);
                    controlPane.setLocation(mouseAnchor);
                    controlPane.setSize(0, 0);
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    dragPoint = e.getPoint();
                    int width = dragPoint.x - mouseAnchor.x;
                    int height = dragPoint.y - mouseAnchor.y;

                    int x = mouseAnchor.x;
                    int y = mouseAnchor.y;

                    if (width < 0) {
                        x = dragPoint.x;
                        width *= -1;
                    }
                    if (height < 0) {
                        y = dragPoint.y;
                        height *= -1;
                    }
                    selectionPane.setBounds(x, y, width, height);
                    selectionPane.revalidate();
                    int controlY = y + height + 5;
                    controlPane.setBounds(x, controlY, width, 25);
                    controlPane.revalidate();
                    repaint();
                }
            };
            addMouseListener(adapter);
            addMouseMotionListener(adapter);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g.create();

            Rectangle bounds = new Rectangle(0, 0, getWidth(), getHeight());
            Area area = new Area(bounds);
            area.subtract(new Area(selectionPane.getBounds()));

            g2d.setColor(new Color(102, 102, 102, 80));
            g2d.fill(area);

        }
    }

    @SuppressWarnings("serial")
    public class ControlPane extends JPanel {
        private JButton btnClose;

        public ControlPane() {
            setOpaque(false);
            btnClose = new JButton("Save");
            setLayout(new BorderLayout());
            this.add(btnClose, BorderLayout.NORTH);

            btnClose.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    complete = true;
                    SwingUtilities.getWindowAncestor(ControlPane.this).dispose();
                }
            });
        }
    }

    @SuppressWarnings("serial")
    public class SelectionPane extends JPanel {

        public SelectionPane() {
            setOpaque(false);

            addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    recX = getX();
                    recY = getY();
                    recWidth = getWidth();
                    recHeight = getHeight();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();

            float strokeWidth = 1.0f;
            float dash1[] = { 10.0f };
            BasicStroke dashed = new BasicStroke(strokeWidth, BasicStroke.CAP_BUTT,
                    BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
            g2d.setColor(Color.BLACK);
            g2d.setStroke(dashed);
            g2d.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            g2d.dispose();
        }
    }

    public static Rectangle getVirtualBounds() {
        Rectangle bounds = new Rectangle(0, 0, 0, 0);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice lstGDs[] = ge.getScreenDevices();
        for (GraphicsDevice gd : lstGDs) {
            bounds.add(gd.getDefaultConfiguration().getBounds());
        }
        return bounds;
    }

    public int[] returnSize() {
        int[] size = new int[4];
        size[0] = recX;
        size[1] = recY;
        size[2] = recWidth;
        size[3] = recHeight;
        return size;
    }
}