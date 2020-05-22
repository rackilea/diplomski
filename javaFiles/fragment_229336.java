import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class RunDrones {

    public static int counterNum = 0;
    final JFrame display;
    private final JLabel counterStatus;
    private final JLabel dialStatus;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                new RunDrones();
            }
        });
    }

    public RunDrones() {

        display = new JFrame();
        display.setLayout(new GridLayout());

        dialStatus = new JLabel("OOPS");
        dialStatus.setFont(new Font("Verdana", 1, 86));
        display.add(dialStatus);

        counterStatus = new JLabel("OOPS");
        counterStatus.setFont(new Font("Verdana", 1, 86));
        display.add(counterStatus);

        display.setSize(800, 400);
        display.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        display.setLocationRelativeTo(null);
        display.setVisible(true);

        Timer dialTimer = new Timer(50, new Dial());
        dialTimer.setInitialDelay(0);

        Timer counterTimer = new Timer(50, new Counter());

        dialTimer.start();
        counterTimer.start();
    }

    public static int getRandom() {
        int firstNum = new Random().nextInt(5) + 1;
        int secondNum = new Random().nextInt(5) + 1;
        return firstNum - secondNum;
    }

    public class Dial implements ActionListener {

        private int dialNum;

        @Override
        public void actionPerformed(ActionEvent e) {

            if (dialNum >= -85 && dialNum <= 60) {
                dialNum += getRandom();
                dialStatus.setText(Integer.toString(dialNum));
            } else {
                ((Timer) e.getSource()).stop();
                dialStatus.setText("ALARM!!");
            }
        }

    }

    public class Counter implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            if (counterNum >= -75 && counterNum <= 75) {
                counterNum += getRandom();
                counterStatus.setText(Integer.toString(counterNum));
            } else {
                ((Timer) e.getSource()).stop();
                counterStatus.setText("ALARM!!");
            }
        }

    }

}