import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class AnimationTrial extends JFrame {

    private final int DELAY = 10;

    private Timer timer;
    private int x, y;
    private JLabel label;

    public static void main(String[] args) {
        EventQueue.invokeLater( new Runnable () {

            @Override
            public void run() {
                new AnimationTrial();
            }

        });
    }

    public AnimationTrial()
    {
        setSize(500, 500);
        x = 50;
        y = 50;

        label = new JLabel("They see me movin' they hatin'!");

        timer = new Timer( DELAY, new ActionListener()
        {

            @Override
            public void actionPerformed(ActionEvent arg0) {

                x++;
                label.setLocation(x, y);    
            }

        });
        timer.start();

        getContentPane().add(label);
        pack();
        setVisible (true);
    }

}