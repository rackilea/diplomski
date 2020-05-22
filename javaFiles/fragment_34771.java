package stack;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class AppendMyError {
    public static void main(String[] args) {
        final String[] errorMsg = {"NullPointerException",
                                   "ArrayIndexOutOfBoundsException",
                                   "OutOfMemoryException"
                                  };


        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run(){
                final JFrame jFrame = new JFrame("Useless Title");
                final JButton errorBtn = new JButton("Click");
                final JTextArea errorLog = new JTextArea(30,30);
                final JScrollPane scroll = new JScrollPane(errorLog);
                final Random rand = new Random();

                jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
                jFrame.getContentPane().add(scroll);
                jFrame.getContentPane().add(errorBtn);
                jFrame.pack();
                jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                jFrame.setVisible(true);

                errorBtn.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent event) {
                        String currentText = errorLog.getText();
                        String newError = new Date() + " " +  errorMsg[rand.nextInt(errorMsg.length)];
                        String newTextToAppend = newError + "\n" + currentText;
                        errorLog.setText(newTextToAppend);
                    }
                });

            }
        });

    }
}