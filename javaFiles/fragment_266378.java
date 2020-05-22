import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringJoiner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Sort {

    public static void main(String[] args) {
        new Sort();
    }

    public Sort() {
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

        private JTextField fieldValues;
        private JTextArea fieldResults;

        public TestPane() {
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.insets = new Insets(2, 2, 2, 2);

            fieldValues = new JTextField(20);
            fieldResults = new JTextArea(10, 20);

            add(fieldValues, gbc);

            JButton btn = new JButton("Sort");
            add(btn, gbc);

            add(new JScrollPane(fieldResults), gbc);

            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String[] values = fieldValues.getText().split(",");
                    int[] contain = new int[values.length];
                    for (int index = 0; index < values.length; index++) {
                        contain[index] = Integer.parseInt(values[index].trim());
                    }
                    for (int pass = 1; pass < contain.length; pass++) {
                        for (int i = 0; i < contain.length - pass; i++) {
                            if (contain[i] > contain[i + 1]) {
                                int temp = contain[i];
                                contain[i] = contain[i + 1];
                                contain[i + 1] = temp;
                                StringJoiner sj = new StringJoiner(", ", "", "\n");
                                for (int value : contain) {
                                    sj.add(Integer.toString(value));
                                }
                                fieldResults.append(sj.toString());
                            }

                        }

                    }
                }
            });
        }

    }

}