import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class SeparatorTest extends JFrame {

    JButton btn1 = new JButton("button1");
    JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL);
    JButton btn2 = new JButton("button2");

    public SeparatorTest() {

        JPanel pane = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        pane.add(sep, gbc);

        getContentPane().add(BorderLayout.NORTH, new JPanel());
        getContentPane().add(BorderLayout.WEST, btn1);
        getContentPane().add(BorderLayout.CENTER, pane);
        getContentPane().add(BorderLayout.EAST, btn2);
        getContentPane().add(BorderLayout.SOUTH, new JPanel());

        setSize(300, 85);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                SeparatorTest frame = new SeparatorTest();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}