import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.Timer;


public class ButtonTimer {

    private JButton button = new JButton(" ");
    private int count = 1;
    public ButtonTimer() {

        Timer timer = new Timer(1000, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                button.setText(String.valueOf(count));
                count++;
            }
        });
        timer.start();

        JFrame frame = new JFrame();
        frame.add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ButtonTimer();
            }
        });
    }
}