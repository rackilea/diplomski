import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class ChangeButton {

    public static void main(String[] args) {
        new ChangeButton();
    }

    public ChangeButton() {
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
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel implements ActionListener {

        private final JButton[][] firstBoard;

        public TestPane() {
            setLayout(new GridLayout(9, 9));
            firstBoard = new JButton[9][9];

            for (int x = 0; x < firstBoard.length; x++) {
                for (int y = 0; y < firstBoard[0].length; y++) {
                    firstBoard[x][y] = new JButton();
                    firstBoard[x][y].setActionCommand("0|" + (x + (firstBoard.length * y)));
                    firstBoard[x][y].addActionListener(this);
                    add(firstBoard[x][y]);
                }
            }
        }

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() instanceof JButton) {
                System.out.println((((JButton) e.getSource()).getActionCommand()));
                ((JButton) e.getSource()).setBackground(Color.BLUE);
                ((JButton) e.getSource()).setContentAreaFilled(false);
                ((JButton) e.getSource()).setOpaque(true);
            }
        }
    }

}