import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {

    //to setThe state of the loop
    public static boolean continueLoop = true;

    public static void main(String[] args) {

        //Create a Frame
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        Dimension d = new Dimension(400, 400);
        frame.setSize(d);

        //Add a button to close the programm or end the loop
        JButton b = new JButton("Close");
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                continueLoop = false;
                //Enable this if you want to close the programm
                //System.exit(0);
            }
        });

        // Start a Thread with your endless loop in it
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                int i = 1;
                while(continueLoop)
                {
                    try {
                        Thread.sleep(500);
                        System.out.println("Try: " + i);
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        t.start();

        // Add a button and set de Frame visible
        frame.add(b);       
        frame.setVisible(true);

    }

}