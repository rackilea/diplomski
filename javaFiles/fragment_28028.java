import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Point;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestComponentLocation {

    public static void main(String[] args) {
        new TestComponentLocation();
    }

    public TestComponentLocation() {
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
                frame.pack();
                frame.setLocationRelativeTo(null);


                Container contentPane = frame.getContentPane();
                contentPane.setLayout(null);
                for (int i = 0; i < 4; i++) {
                    JPanel panel = new JPanel();
                    panel.setBounds((i * 75) + 475, 25, 75, 100);
                    System.out.println(panel.getBounds());
                    contentPane.add(panel);
                    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
                }
                System.out.println(getComponentAt(contentPane, new Point(475, 25)));
                System.out.println(getComponentAt(contentPane, new Point(100, 25)));

                frame.setVisible(true);

            }
        });
    }

    public Component getComponentAt(Container parent, Point p) {
        Component comp = null;
        for (Component child : parent.getComponents()) {
            if (child.getBounds().contains(p)) {
                comp = child;
            }
        }
        return comp;
    }
}