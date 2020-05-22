import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Test3 extends JFrame {

    JButton button;
    JButton b2;
    JTextArea text;
    JFileChooser fileChooser;
    int returnVal;

    public Test3() {
        text = new JTextArea(20, 40);
        button = new JButton("Read");
        button.addActionListener(new Listener());
        b2 = new JButton("Write");
        b2.addActionListener(new Listener());

        add(button, BorderLayout.NORTH);
        add(text, BorderLayout.CENTER);
        add(b2, BorderLayout.SOUTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Test3();
            }
        });

    }

    private class Listener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == button) {
                fileChooser = new JFileChooser();
                returnVal = fileChooser.showOpenDialog(Test3.this);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        // What to do with the file, e.g. display it in a TextArea
                        text.read(new FileReader(file.getAbsolutePath()), null);
                    } catch (IOException ex) {
                    }
                } else {
                }
            }

            if (e.getSource() == b2) {
                String[] token = text.getText().split("[\\n\\s]+");
                for (String s : token) {
                    System.out.println(s);
                }
            }
        }
    }
}