import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextDemo extends JFrame implements ActionListener {
    JTextField textData;
    JButton button = new JButton("Press Me");

    public TextDemo() {
        JPanel myPanel = new JPanel();
        add(myPanel);
        myPanel.setLayout(new GridLayout(3, 2));
        myPanel.add(button);
        button.addActionListener(this);
        textData = new JTextField();
        myPanel.add(textData);
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            String data = textData.getText(); // perform your DB operation
            textData.setText(data + " This is new text"); // Set your DB values.
        }
    }

    public static void main(String args[]) {
        TextDemo g = new TextDemo();
        g.setLocation(10, 10);
        g.setSize(300, 300);
        g.setVisible(true);
    }
}