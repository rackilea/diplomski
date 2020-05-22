import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Mover extends JFrame {

    private JPanel jPanel;
    private JLabel jLabel1;
    private JLabel jLabel2;

    public Mover() {
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jPanel = new JPanel(null);
        jLabel1 = new JLabel("label one");
        jLabel2 = new JLabel("label two");

        jLabel1.setBounds(100, 100, 100, 100);
        jLabel2.setBounds(100, 100, 100, 100);

        MouseMotionListener mover = new MouseMotionListener() {

            @Override
            public void mouseMoved(MouseEvent e) {
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("Label One");

                Component child = e.getComponent();
                Point p = e.getPoint();
                p = SwingUtilities.convertPoint(e.getComponent(), p, e.getComponent().getParent());

                int myXX = p.x - (child.getWidth() / 2);
                int myYY = p.y - (child.getHeight() / 2);
                child.setLocation(myXX, myYY);
                repaint();
            }
        };

        jLabel1.addMouseMotionListener(mover);
        jLabel2.addMouseMotionListener(mover);

        jPanel.add(jLabel1);
        jPanel.add(jLabel2);
        add(jPanel);
        setVisible(true);
    }

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                new Mover();
            }
        });
    }
}