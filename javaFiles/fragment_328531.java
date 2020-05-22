import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

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

    public static class TestPane extends JPanel {

        protected static final Border NORMAL_BORDER = BorderFactory.createLineBorder(Color.BLACK, 4);
        protected static final Border ROLLOVER_BORDER = BorderFactory.createLineBorder(Color.RED, 4);

        public TestPane() {

            JButton btn = new JButton("Click me!");
            btn.setContentAreaFilled(false);
            btn.setBorder(NORMAL_BORDER);
            btn.getModel().addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    if (btn.getModel().isRollover()) {
                        btn.setBorder(ROLLOVER_BORDER);
                    } else {
                        btn.setBorder(NORMAL_BORDER);
                    }
                }
            });

            setLayout(new GridBagLayout());
            add(btn);

        }

    }

}