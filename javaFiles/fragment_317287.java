import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class LayoutExample {

    public static void main(String[] args) {
        new LayoutExample();
    }

    public LayoutExample() {
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
                frame.add(new ProgressPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ProgressPane extends JPanel {

        private JProgressBar pb;
        private JButton start;
        private JButton cancel;

        public ProgressPane() {

            pb = new JProgressBar();
            start = new JButton("Start");
            cancel = new JButton("Cacnel");

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.insets = new Insets(50, 10, 5, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.weightx = 1;
            gbc.gridwidth = 2;
            add(pb, gbc);

            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.insets = new Insets(0, 0, 0, 5);
            gbc.fill = GridBagConstraints.NONE;
            gbc.weightx = 1;
            gbc.gridwidth = 1;
            gbc.anchor = GridBagConstraints.EAST;
            add(start, gbc);

            gbc.weightx = 0;
            gbc.gridx = 1;
            gbc.insets = new Insets(0, 0, 0, 10);
            gbc.anchor = GridBagConstraints.WEST;
            add(cancel, gbc);

        }


    }
}