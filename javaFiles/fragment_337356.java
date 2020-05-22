import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/** @see http://stackoverflow.com/q/9793194/230513 */
public class FurnitureTest {

    private static final class FurniturePanel
        extends JPanel implements ActionListener {

        private static final int N = 3;
        private static final Icon icon =
            UIManager.getIcon("OptionPane.informationIcon");
        private JPanel westPanel = new JPanel();
        private JPanel centerPanel = new JPanel();
        private JButton[] commandButtons = {
            new JButton("Add Chair"),
            new JButton("Add Table"),
            new JButton("Add Desk"),
            new JButton("Clear All"),
            new JButton("Total Price"),
            new JButton("Save"),
            new JButton("Load"),
            new JButton("Summary")
        };

        FurniturePanel() {
            this.setLayout(new GridLayout());
            westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));

            for (JButton b : commandButtons) {
                b.setAlignmentX(JButton.CENTER_ALIGNMENT);
                westPanel.add(b);
                b.addActionListener(this);
            }
            this.add(westPanel, BorderLayout.WEST);

            centerPanel.setLayout(new GridLayout(N, N, N, N));
            for (int i = 0; i < N * N; i++) {
                centerPanel.add(new JLabel(icon));
            }
            this.add(centerPanel, BorderLayout.CENTER);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame application = new JFrame();
                FurniturePanel panel = new FurniturePanel();
                application.add(panel);
                application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                application.pack();
                application.setLocationByPlatform(true);
                application.setVisible(true);
            }
        });

    }
}