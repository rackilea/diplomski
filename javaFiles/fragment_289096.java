package javaapplication3;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class Main {

public static void main(String[] args)
        throws Exception {
    SwingUtilities.invokeAndWait(new Runnable() {

        final JLabel jLabel = new JLabel("Please wait...");

        @Override
        public void run() {
            JFrame myFrame = new JFrame("Main frame");
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.setSize(750, 500);
            myFrame.setLocationRelativeTo(null);
            myFrame.setVisible(true);

            JDialog d = new JDialog(myFrame, "I'm waiting");

            d.add(jLabel);
            d.setSize(300, 200);
            d.setLocationRelativeTo(null);
            d.setVisible(true);

            new Thread(new Runnable() {

                @Override
                public void run() {

                public void run() {
                    try {
                        Thread.sleep(3000); // simulate process
                        jLabel.setText("Done");   // HERE: should be done on EDT!
                    } catch (InterruptedException ex) {
                    }
                }
            }).start();


        }
    });
}
}