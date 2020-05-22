import java.awt.EventQueue;
import java.awt.GridLayout;
import javax.swing.*;

public class Demo {

    private JFrame jf;
    private JLabel[] labels;
    private JPanel panel;

    public Demo() {
        labels = new JLabel[10];
        Box vbox = Box.createVerticalBox();
        for (int i = 0; i < 10; i++) {
            labels[i] = new JLabel();
            labels[i].setText("10000000000000000000000000000000000000");
            vbox.add(labels[i]);
        }
        panel = new JPanel();
        panel.setLayout(new GridLayout());
        panel.add(vbox);
        jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.add(panel);
        jf.pack();
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new DemoRunnable());
    }

    public void updateState() {
        for (final JLabel l : labels) {
            if (Math.random() > 0.5) {
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        l.setText("777777777777777777777777777777777777");
                    }
                });
            } else {
                EventQueue.invokeLater(new Runnable() {

                    @Override
                    public void run() {
                        l.setText("10000000000000000000000000000000000000");
                    }
                });
            }
        }
    }
}

class DemoRunnable implements Runnable {

    private Demo demo;

    DemoRunnable() {
        this.demo = new Demo();
    }

    @Override
    public void run() {
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    demo.updateState();
                }
            }
        });
        t.start();
    }
}