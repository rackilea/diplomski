import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Globals {
    public static int seconds = 0;
}

class Main {
    public static void main(String Args[]) {

        //text timeline = new text();
        JFrame testing = new JFrame();
        testing.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        testing.setSize(1000,1000);
        testing.setVisible(true);

        JLabel countDownLabel = new JLabel();
        countDownLabel.setText("Now it's : " + Globals.seconds);
        testing.add(countDownLabel);

        CountDown countdown = new CountDown(countDownLabel);
        Timer timer = new Timer(5000, countDown);
        timer.start();
    }
}

class CountDown implements ActionListener {
    private JLabel countDownLabel;

    public CountDown(JLabel countDownLabel) {
        this.countDownLabel = countDownLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Globals.seconds++;
        this.countDownLabel.setText("Now it's : " + Globals.seconds);
    }
}