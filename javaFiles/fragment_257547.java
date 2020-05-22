import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

        JTextField text;
        JTextField text2 = new JTextField("Enter Year", 40);
        JLabel label1;
        String Input1;
        String Input2;
        int month;
        int year;
        int numDays = 0;

        public TestPane() {
            setLayout(new GridBagLayout());
            text = new JTextField("Enter month's #", 40);
            text2.addActionListener(new MyActionListener());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(text, gbc);
            add(text2, gbc);
        }

        class MyActionListener implements ActionListener {

            public void actionPerformed(ActionEvent evt) {
                Input1 = text.getText();
                Input2 = text2.getText();
                month = Integer.parseInt(Input1);
                year = Integer.parseInt(Input2);
                math(month, year);
            }
        }

        public void math(int month, int year) {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            switch (month) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    numDays = 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    numDays = 30;
                    break;
                case 2:
                    if (((year % 4 == 0)
                                    && !(year % 100 == 0))
                                    || (year % 400 == 0)) {
                        numDays = 29;
                    } else {
                        numDays = 28;
                    }
                    break;
                default:
                    label1 = new JLabel("Invalid input...");
                    add(label1, gbc);
                    break;
            }
            label1 = new JLabel(Integer.toString(numDays));
            add(label1, gbc);
        }

    }
}