import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LearnAppMain extends JFrame implements ActionListener {

// Define variables
public JButton button1;
public JLabel label1;
    public JTextField field1;

    private Image image1;
private String apple = "apple.jpg";

public LearnAppMain() {

    //ImageIcon image1 = new ImageIcon(this.getClass().getResource(apple));
    //JLabel label1 = new JLabel(image1);
    label1 = new JLabel("hello");
    label1.setVisible(false);

    button1 = new JButton("A");
    button1.addActionListener(this);

    field1 = new JTextField(10);

    // Create layout
    setLayout(new FlowLayout());

    // create Container
    final Container cn = getContentPane();

    cn.add(button1);
    cn.add(field1);
    cn.add(label1);

    // setLayout(new FlowLayout());
    setSize(250, 250);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {

    Object source = e.getSource();

    if (e.getSource() == button1) {
        label1.setVisible(true);
        field1.setText("Apple");
    }

}
public static void main(String[] args) {
  new LearnAppMain();
}
}