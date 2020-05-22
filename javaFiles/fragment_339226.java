import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                final JFrame frame = new JFrame("Lingvo frame");

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                final JButton showResultButton = new JButton();
                final JTextArea textArea = new JTextArea(20, 60);

                frame.setLayout(new GridLayout(2, 1));
                frame.add(textArea);
                frame.add(showResultButton);

                frame.pack();
                frame.setVisible(true);

                showResultButton.addActionListener(new ActionListener() {

                    public void actionPerformed(ActionEvent arg0) {
                        showResultButton.setText("translation");
                    }
                });
            }
        });
    }
}