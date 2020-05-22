import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Application {

    public static void main(String[] args) {
        new Application();
    }

    public Application() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new GridBagLayout());
            String labels[][] = new String[][]{{"7", "8", "9"}, {"4", "5", "6"}, {"1", "2", "3"}};
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridy = 0;
            for (String[] row : labels) {
                gbc.gridx = 0;
                for (String col : row) {
                    add(new JButton(col), gbc);
                    gbc.gridx++;
                }
                gbc.gridy++;
            }
            gbc.gridx = 0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridwidth = 3;
            add(new JButton("0"), gbc);
        }

    }

}