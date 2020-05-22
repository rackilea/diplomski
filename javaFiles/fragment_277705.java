import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main {
    private static final Timer timer = new Timer(1000, Main::run);

    public static void main(final String[] args) {
        final JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setMinimumSize(new Dimension(200, 200));

        final JButton startButton = new JButton("start");
        startButton.addActionListener(e -> timer.start());
        frame.add(startButton);

        final JButton stopButton = new JButton("stop");
        stopButton.addActionListener(e -> timer.stop());
        frame.add(stopButton);

        frame.setVisible(true);
    }

    private static void run(final ActionEvent e) {
        System.out.println("do stuff");
    }
}