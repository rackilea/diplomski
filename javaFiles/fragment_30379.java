import java.awt.Container;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Test {

    private static JFrame mainFrame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainFrame = new JFrame("test");
                mainFrame.setSize(300, 100);
                mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                mainFrame.setVisible(true);

                Container pane = mainFrame.getContentPane();
                MouseAdapter ma = new MouseAdapter() {
                    private Point offset;

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

                        Point pos = SwingUtilities.getWindowAncestor(e.getComponent()).getLocation();

//                      Point pos = e.getComponent().getLocationOnScreen();
                        offset = new Point(e.getLocationOnScreen());
                        System.out.println(pos + "/" + offset);
                        offset.x -= pos.x;
                        offset.y -= pos.y;

                        System.out.println(offset);
                    }
                };
                pane.addMouseListener(ma);
                pane.addMouseMotionListener(ma);
            }
        });
    }
}