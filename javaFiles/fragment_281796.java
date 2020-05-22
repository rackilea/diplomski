import javax.swing.*;
import java.awt.event.*;

public class ShowInputDialog{
    public static void main(String[] args){
        JFrame frame = new JFrame("Input Dialog Box Frame");
        JButton button = new JButton("Show Input Dialog Box");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                JTextField xField = new JTextField(5);
                JTextField yField = new JTextField(5);

                JPanel myPanel = new JPanel();
                myPanel.add(new JLabel("x:"));
                myPanel.add(xField);
                myPanel.add(Box.createHorizontalStrut(15)); // a spacer
                myPanel.add(new JLabel("y:"));
                myPanel.add(yField);

                int result = JOptionPane.showConfirmDialog(null, myPanel, 
                         "Please Enter X and Y Values", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                   System.out.println("x value: " + xField.getText());
                   System.out.println("y value: " + yField.getText());
                }
            }
        });
        JPanel panel = new JPanel();
        panel.add(button);
        frame.add(panel);
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}