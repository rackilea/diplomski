import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class DisplayMessageTrial extends JFrame {

private JPanel jPanel1;
private JButton button = new JButton("Click Me!");

public DisplayMessageTrial() {
    super("DisplayMessageTrial");
    jPanel1 = new JPanel();
    jPanel1.add(button);
    setContentPane(jPanel1);
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            jButton1ActionPerformed(e);
        }
    });
}

public void addTextTry(){
    JLabel l1 = new JLabel("The add method appends an element to an array.");
    JLabel l2 = new JLabel("This inturn increases the arrays size.");
    jPanel1.add(l1);
    jPanel1.add(l2);
    jPanel1.revalidate();
}

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
    addTextTry();
}  


public static void main(String[] args) {
    DisplayMessageTrial trial = new DisplayMessageTrial();
    trial.setBounds(100, 100, 300, 300);
    trial.setVisible(true);
}

}