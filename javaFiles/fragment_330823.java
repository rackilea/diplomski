import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Chocies {

    public static void main(String[] args) {
        new Chocies();
    }

    public Chocies() {
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

    public class TestPane extends JPanel {

        private JButton choice1;
        private JButton choice2;
        private JButton choice3;

        private JLabel output;

        private JButton choice;

        public TestPane() {
            setLayout(new BorderLayout());
            choice1 = new JButton("Door 1");
            choice2 = new JButton("Door 2");
            choice3 = new JButton("Door 3");
            JPanel panel = new JPanel();
            panel.add(choice1);
            panel.add(choice2);
            panel.add(choice3);

            output = new JLabel("Pick a door");
            output.setHorizontalAlignment(JLabel.CENTER);

            add(output, BorderLayout.NORTH);
            add(panel);

            ButtonHandler handler = new ButtonHandler();
            choice1.addActionListener(handler);
            choice2.addActionListener(handler);
            choice3.addActionListener(handler);
        }

        public class ButtonHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                output.setText("Wait for it...");
                choice = (JButton) e.getSource();
                choice1.setEnabled(false);
                choice2.setEnabled(false);
                choice3.setEnabled(false);
                Timer timer = new Timer(1000, new TimerHandler());
                timer.setRepeats(false);
                timer.start();
            }

        }

        public class TimerHandler implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (choice1 == choice) {
                    output.setText("Door 1 selected");
                } else if (choice2 == choice) {
                    output.setText("Door 2 selected");
                } else if (choice3 == choice) {
                    output.setText("Door 3 selected");
                }

                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        choice1.setEnabled(true);
                        choice2.setEnabled(true);
                        choice3.setEnabled(true);
                    }
                });
                timer.setRepeats(false);
                timer.start();
            }

        }

    }

}