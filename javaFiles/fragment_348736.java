import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Test {

    protected void initUI() {
        final JFrame frame = new JFrame();
        frame.setTitle("Test dialog synch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // On the next line I pass "frame" to the dialog so that the dialog never
            // goes behind the frame, avoiding the need for setAlwaysOnTop
        final JDialog dialog = new JDialog(frame, false);
        dialog.setSize(200, 50);
        frame.addComponentListener(new ComponentAdapter() {

            private Point lastLocation;

            @Override
            public void componentMoved(ComponentEvent e) {
                if (lastLocation == null && frame.isVisible()) {
                    lastLocation = frame.getLocation();
                } else {
                    Point newLocation = frame.getLocation();
                    int dx = newLocation.x - lastLocation.x;
                    int dy = newLocation.y - lastLocation.y;
                    dialog.setLocation(dialog.getX() + dx, dialog.getY() + dy);
                    lastLocation = newLocation;
                }
            }

        });
        frame.setSize(400, 200);
        frame.setVisible(true);
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Test().initUI();
            }
        });
    }

}