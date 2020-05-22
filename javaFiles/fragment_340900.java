import java.awt.CardLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

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
                frame.add(new Govinda());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class Govinda extends JPanel {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        private JPanel panel;
        private JPanel panel_1;

        /**
         * Create the frame.
         */
        public Govinda() {
            setBorder(new EmptyBorder(5, 5, 5, 5));
            setLayout(new CardLayout(0, 0));

            JPanel panel = new JPanel();
            add(panel, "name_273212774632866");

            JButton btnNewButton = new JButton("New button");
            btnNewButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    ((CardLayout) getLayout()).show(Govinda.this, "name_273214471684839");
                }
            });
            panel.add(btnNewButton);

            JPanel panel_1 = new JPanel();
            add(panel_1, "name_273214471684839");

            JLabel lblHaiiiiiiiii = new JLabel("HAIIIIIIIII");
            panel_1.add(lblHaiiiiiiiii);
        }
    }
}