import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestMoveWindow {

    public static void main(String[] args) {
        new TestMoveWindow();
    }

    public TestMoveWindow() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JWindow window = new JWindow();
                window.setSize(200, 200);
                window.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        System.exit(0);
                    }

                });

                MouseAdapter mouseHandler = new MouseAdapter() {

                    private Point offset;

                    protected boolean isWithinBorder(MouseEvent e) {
                        Point p = e.getPoint();
                        Component comp = e.getComponent();
                        return p.x < 10 || p.y < 10 || p.x > comp.getWidth() - 10 || p.y > comp.getHeight()  - 10;
                    }

                    @Override
                    public void mouseMoved(MouseEvent e) {
                        Component comp = e.getComponent();
                        if (isWithinBorder(e)) {
                            System.out.println("Move");
                            comp.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
                        } else {
                            System.out.println("Default");
                            comp.setCursor(Cursor.getDefaultCursor());
                        }
                    }

                    @Override
                    public void mouseDragged(MouseEvent e) {
                        if (offset != null) {
                            Point pos = e.getLocationOnScreen();

                            int x = pos.x - offset.x;
                            int y = pos.y - offset.y;

                            System.out.println(x + "x" + y);

                            SwingUtilities.getWindowAncestor(e.getComponent()).setLocation(x, y);
                        }
                    }

                    @Override
                    public void mousePressed(MouseEvent e) {
                        if (isWithinBorder(e)) {
                            Point pos = e.getComponent().getLocationOnScreen();
                            offset = new Point(e.getLocationOnScreen());
                            offset.x -= pos.x;
                            offset.y -= pos.y;
                        }
                    }

                };

                window.getContentPane().addMouseListener(mouseHandler);
                window.getContentPane().addMouseMotionListener(mouseHandler);

                window.setLocationRelativeTo(null);
                window.setVisible(true);
            }
        });
    }
}