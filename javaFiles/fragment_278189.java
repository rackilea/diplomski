import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

                JDialog dialog = new JDialog();
                dialog.setTitle("Testing");
                dialog.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                dialog.add(new TestPane());
                dialog.pack();
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);

                System.out.println("Now back in the main...");
            }
        });
    }

    public class TestPane extends JPanel {

        private JTextField field;

        public TestPane() {

            setLayout(new GridBagLayout());

            field = new JTextField(10);
            field.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    if ("exitsys".equals(field.getText())) {
                        SwingUtilities.getWindowAncestor(field).dispose();
                    }
                }
            });

            add(field);

        }

    }

}