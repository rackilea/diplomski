import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Demo {
    public static void main(String[] args) {
            JFrame frame = new JFrame("Select file");
            frame.setSize(400, 300);
            // disable default close behaviour of JFrame
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

            JFileChooser chooser = new JFileChooser();
            frame.add(chooser, BorderLayout.CENTER);

            // little helper to close the JFrame properly
            Runnable closeFrame = () -> {
                frame.setVisible(false);
                frame.dispose();
            };

            chooser.addActionListener((ActionEvent e) -> {
                if (e.getActionCommand() ==
                        JFileChooser.APPROVE_SELECTION) {
                    closeFrame.run();
                    System.out.println("User pressed approve button.");
                    File selectedFile = chooser.getSelectedFile();
                } else if (e.getActionCommand() ==
                        JFileChooser.CANCEL_SELECTION) {
                    closeFrame.run();
                    System.out.println("User pressed cancel button.");
                }
            });

            frame.addWindowListener(new WindowAdapter() {

                @Override
                public void windowClosing(WindowEvent e) {
                    // You could tell the user here
                    // that he has to select a file…
                    closeFrame.run();
                    System.out.println("User closed JFrame.");
                }
            });

            frame.setVisible(true);
    }
}