import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventTest {

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                final JComponent outside = new JPanel();
                JComponent inside = new JPanel();
                inside.setBackground(Color.red);
                inside.setPreferredSize(new Dimension(200, 200));
                inside.addMouseMotionListener(new MouseAdapter() {

                    @Override
                    public void mouseDragged(MouseEvent e) {
                        System.err.println("dragged");
                    }

                    @Override
                    public void mouseMoved(MouseEvent e) {
                        System.err.println("moved inside");
                        outside.dispatchEvent(e);
                    }
                });

                outside.add(inside);
                outside.setPreferredSize(new Dimension(300, 300));
                outside.addMouseMotionListener(new MouseAdapter() {

                    @Override
                    public void mouseMoved(MouseEvent arg0) {
                        System.err.println("moved outside");
                    }
                });

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(outside);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}