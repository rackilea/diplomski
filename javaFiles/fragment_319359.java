import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainF extends JFrame {

public static void main(String[] args) {
    MainF f = new MainF();
    f.setVisible(true);

}


public MainF() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setBounds(100, 100, 600, 300);
    this.setLayout(new FlowLayout());

    JButton someButton = new JButton("Some Text");
    JButton someOtherButton = new JButton("Some Other Text");
    //Add an anonymous one
    someButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "I was clicked and handled anonymously!");
        } });
    //add a defined one to our other button
    someOtherButton.addActionListener(new buttonListener());
    this.add(someButton);
    this.add(someOtherButton);
}


private class buttonListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(null, "I was clicked and handled by buttonListener!");
    }

}

}