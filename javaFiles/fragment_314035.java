public class firstClass extends JFrame implements ActionListener {

...

    item1.addActionListener(this);
    item2.addActionListener(this);
    item3.addActionListener(this);

    passwordField.addActionListener(this);


}

public void actionPerformed(ActionEvent event) {

    String string = "";

    if (event.getSource() == item1)
        string = String.format("field 1: %s", event.getActionCommand());
    else if (event.getSource() == item2)
        string = String.format("field 2: %s", event.getActionCommand());
    else if (event.getSource() == item3)
        string = String.format("field 3: %s", event.getActionCommand());
    else if (event.getSource() == passwordField)
        string = String.format("Password Field is : %s", event.getActionCommand());

    JOptionPane.showMessageDialog(null, string);


}