package fr.free.jnizet.stackoverflow;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;


public class ThreadedDialog  extends JFrame implements ActionListener{
    private JDialog dlg;
    private JButton button;

    private void buildInterface(){
        button = new JButton("do stuff;");
        button.addActionListener(this);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(BorderLayout.CENTER, button);


        dlg = new JDialog(this, "Progress Dialog", true);
        JProgressBar dpb = new JProgressBar(0, 500);
        dlg.getContentPane().setLayout(new BorderLayout());
        dlg.getContentPane().add(BorderLayout.CENTER, dpb);
        dlg.getContentPane().add(BorderLayout.NORTH, new JLabel("Progress..."));
        dlg.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        dlg.setSize(300, 75);
        dlg.setLocationRelativeTo(this);
        dpb.setIndeterminate(true);
    }

    public void doSomething(){
        // create a thread for the background task
        Thread t = new Thread(new Runnable(){
            public void run() {
                try {
                    for (int i=0; i<100; i++){
                        System.out.println("wtf is going on here?");
                        Thread.sleep(5000);
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // when the background task is finished, hide the dialog in the EDT.
                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        dlg.setVisible(false);
                    }

                });
            }
        });
        t.start();

        // show the dialog in the EDT
        dlg.setVisible(true);
    }

    public static void main(String[] args) {
        // create the GUI in the EDT
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ThreadedDialog me = new ThreadedDialog();

                me.buildInterface();
                me.pack();
                me.setVisible(true);
                me.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });

    }

    public void actionPerformed(ActionEvent event) {
        doSomething();
    }
}