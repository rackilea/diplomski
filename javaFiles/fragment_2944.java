package swing.imagetest;    

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;
    
public class ComboExample {

    private String[] data = new String[]{
                                            "geek0",
                                            "geek1",
                                            "geek2",
                                            "geek3",
                                            "geek4"
                                        };
    private String MESSAGE = "No Image to display yet...";
    private JLabel imageLabel;
    private JComboBox cBox;
    private ActionListener comboActions = 
                            new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            JComboBox combo = (JComboBox) ae.getSource();
            ImageIcon image = new ImageIcon(
                        getClass().getResource(
                            "/" + combo.getSelectedItem() + ".gif"));
            if (image != null) {
                imageLabel.setIcon(image);
                imageLabel.setText("");
            } else {
                imageLabel.setText(MESSAGE);
            }
        }    
    };

    private void displayGUI() {
        JFrame frame = new JFrame("Combo Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel contentPane = new JPanel();
        imageLabel = new JLabel(MESSAGE, JLabel.CENTER);
        cBox = new JComboBox(data);
        cBox.addActionListener(comboActions);

        contentPane.add(imageLabel);
        contentPane.add(cBox);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public static void main(String... args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ComboExample().displayGUI();
            }
        });
    }
}