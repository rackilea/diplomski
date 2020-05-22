import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TimedButtonClickDemo {

    private JButton button = null;

    public TimedButtonClickDemo() {
        button = getTimedButton();
        JFrame frame = new JFrame();
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    public JButton getTimedButton() {
        JButton button = new JButton("Press Me");
        button.addActionListener(new TimerButtonListener());
        return button;
    }

    private class TimerButtonListener implements ActionListener {

        private Timer timer = null;
        private boolean isFirstClick = true;

        public TimerButtonListener() {
            timer = new Timer(5000, new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    button.setEnabled(false);
                    System.out.println("Too slow, Jack! Better eat your Wheaties!");
                }
            });
            timer.setRepeats(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isFirstClick) {
                button.setText("Press Again");
                timer.start();
                isFirstClick = false;
            } else {
                timer.stop();
                button.setText(" Press Me ");
                isFirstClick = true;
                System.out.println("You did it. Must be on that Red Bull");
            }   
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TimedButtonClickDemo();
            }
        });
    }
}