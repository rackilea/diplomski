import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
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

        private int rows = 15;
        private int columns = 6;

        public TestPane() {
            setLayout(new GridLayout(rows, columns));
            for (int row = 0; row < rows; row++) {
                String[] rowChar = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
                for (int column = 1; column < columns + 1; column++) {

                    final JToggleButton button = new JToggleButton(rowChar[row] + column);
                    button.addActionListener(new ActionListener() {

                        @Override
                        public void actionPerformed(ActionEvent actionEvent) {
                            AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
                            boolean selected = abstractButton.getModel().isSelected();
                            if (selected) {
                                button.setText("X");
                            } else {
                                button.setText("");
                            }
                            SwingUtilities.getWindowAncestor(button).dispose();
                        }
                    });
                    add(button);
                }
            }
        }

    }

}