package test;

import java.awt.BorderLayout;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Test extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextArea tarea;

    public Test() {
        tarea = new JTextArea(10, 10);
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scroll = new JScrollPane(tarea);
        getContentPane().add(scroll, BorderLayout.CENTER);
        pack();
        setLocationByPlatform(true);
        setVisible(true);
        insertRandomLetterInsideJtextArea();
    }

    private void insertRandomLetterInsideJtextArea() {

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            String content = "";
            @Override
            public void run() {
                content += "foo\n"; // here generate your random String
                tarea.setText(content);
            }
        }, 100, 1000); // firt is time before start, second is duration before repeat task, both in ms

    }

    public static void main(String... args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test().init();
            }
        });
    }
}