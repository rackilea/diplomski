import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import org.openstreetmap.gui.jmapviewer.DefaultMapController;
import org.openstreetmap.gui.jmapviewer.JMapViewer;

/**
 * @see https://stackoverflow.com/a/39461854/230513
 */
public class TestMapController {

    private void display() {
        JFrame f = new JFrame("TestMapController");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMapViewer map = new JMapViewer();
        new DefaultMapController(map) {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getPoint());
            }
        };
        f.add(map);
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new TestMapController()::display);
    }
}