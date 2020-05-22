import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class GuiApp1 {
protected void twoscreen() {
    Point p1 = null;
    Point p2 = null;
    for (GraphicsDevice gd : GraphicsEnvironment.getLocalGraphicsEnvironment ().getScreenDevices()) {
        if (p1 == null) {
            p1 = gd.getDefaultConfiguration().getBounds().getLocation();
        } else if (p2 == null) {
            p2 = gd.getDefaultConfiguration().getBounds().getLocation();
        }
    }
    if (p2 == null) {
        p2 = p1;
    }
    createFrameAtLocation(p1);
    createFrameAtLocation(p2);
 }

 private void createFrameAtLocation(Point p) {
    final JFrame frame = new JFrame();
    frame.setTitle("Test frame on two screens");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel = new JPanel(new BorderLayout());
    final JTextArea textareaA = new JTextArea(24, 80);
    textareaA.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 1));
    panel.add(textareaA, BorderLayout.CENTER);
    frame.setLocation(p);
    frame.add(panel);
    frame.pack();
    frame.setExtendedState(Frame.MAXIMIZED_BOTH);
    frame.setVisible(true);
 }

 public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {


        public void run() {
            new GuiApp1().twoscreen();
        }
    });
 }

}