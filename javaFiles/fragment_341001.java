import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
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
            setLayout(new GridLayout(1, 5));
            add(createPanel(Color.WHITE));
            add(createPanel(Color.BLACK));
            add(createPanel(Color.RED));
            add(createPanel(Color.GREEN));
            add(createPanel(Color.BLUE));
        }

        protected JPanel createPanel(Color color) {
            JPanel panel = new JPanel() {
                @Override
                public Dimension getPreferredSize() {
                    return new Dimension(50, 50);
                }
            };
            panel.setBackground(color);
            return panel;
        }

    }

}