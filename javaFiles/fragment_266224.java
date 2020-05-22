import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TimeFrame extends JFrame {

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TimeFrame().setVisible(true);
            }
        });
    }

    private JButton currentTime;
    private JLabel currentTimeLabel;
    private JTextField currentTimeField;
    private int click;
    private JTextField clicktest;

    public TimeFrame() {
        currentTimeLabel = new JLabel("The Current Time is: ");

        createTextField();
        createButton();
        createPanel();

        pack();
        setLocationRelativeTo(null);
        initialize();

    }

    private void initialize() {
        click = 0;
    }

    private void createTextField() {
        final int FIELD_WIDTH = 10;
        currentTimeField = new JTextField(FIELD_WIDTH);
        Date now = new Date();
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        currentTimeField.setText("" + dateFormat.format(now));

        clicktest = new JTextField(FIELD_WIDTH);
        clicktest.setText(" " + click);

    }

    private void createButton() {
        currentTime = new JButton("Display Current Time");

        ActionListener listener = new AddCurrentTimeListener();
        currentTime.addActionListener(listener);

    }

    private void createPanel() {
        setLayout(new FlowLayout());
        //panel.addActionListener(backgroundListener);
        add(currentTimeLabel);
        add(currentTimeField);
        add(currentTime);
        add(clicktest);
    }

    class AddCurrentTimeListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            new java.util.Date();
            Date now = new Date();
            DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
            currentTimeField.setText("" + dateFormat.format(now));
            getClass();
            if (click < 4) {
                click++;
            } else {
                click = click - 4;
            }

            clicktest.setText("" + click);

            if (click == 0) {
                getContentPane().setBackground(Color.ORANGE);
            } else if (click == 1) {
                getContentPane().setBackground(Color.YELLOW);
            } else if (click == 2) {
                getContentPane().setBackground(Color.BLUE);
            } else if (click == 3) {
                getContentPane().setBackground(Color.GREEN);
            } else if (click == 4) {
                getContentPane().setBackground(Color.PINK);
            }
            repaint();
        }

    }

}